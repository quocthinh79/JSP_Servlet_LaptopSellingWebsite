/*
 * BSTable
 * @description  Javascript (JQuery) library to make bootstrap tables editable. Inspired by Tito Hinostroza's library Bootstable. BSTable Copyright (C) 2020 Thomas Rokicki
 *
 * @version 1.0
 * @author Thomas Rokicki (CraftingGamerTom), Tito Hinostroza (t-edson)
 */

"use strict";

/** @class BSTable class that represents an editable bootstrap table. */
let command = '';
let temp = '';
let dieuKienUpdate = '';
let contentBefore = '';

class BSTable {

    /**
     * Creates an instance of BSTable.
     *
     * @constructor
     * @author: Thomas Rokicki (CraftingGamerTom)
     * @param {tableId} tableId The id of the table to make editable.
     * @param {options} options The desired options for the editable table.
     */
    constructor(tableId, options) {

        var defaults = {
            editableColumns: null,          // Index to editable columns. If null all td will be editable. Ex.: "1,2,3,4,5"
            $addButton: null,               // Jquery object of "Add" button
            onEdit: function () {
            },
            advanced: {                     // Do not override advanced unless you know what youre doing
                columnLabel: 'Actions',
                buttonHTML: `<div class="btn-group pull-right">
                <button id="bEdit" type="button" class="btn btn-sm btn-default">
                    <span class="fa fa-edit" > </span>
                </button>
                <button id="bAcep" type="button" class="btn btn-sm btn-default" style="display:none;">
                    <span class="fa fa-check-circle" > </span>
                </button>
                <button id="bCanc" type="button" class="btn btn-sm btn-default" style="display:none;">
                    <span class="fa fa-times-circle" > </span>
                </button>
            </div>`
            }
        };

        this.table = $('#' + tableId);
        this.options = $.extend(true, defaults, options);

        /** @private */ this.actionsColumnHTML = '<td name="bstable-actions">' + this.options.advanced.buttonHTML + '</td>';

        //Process "editableColumns" parameter. Sets the columns that will be editable
        // if (this.options.editableColumns != null) {
        //   // console.log("[DEBUG] editable colu
        // <script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha384-vk5WoKIaW/vJyUAd9n/wmopsmNhiy+L2Z+SBxGYnUkunIxVxAv/UtMOhba/xskxh" crossorigin="anonymous"></script>
        // <script src="../js/bstable.js"></script>
        // <script>
        //     // Basic example
        //     var example1 = new BSTable("table1", {
        //         $addButton: $('#addRow'),
        //         advanced: {
        //             columnLabel: ''
        //         }
        //     });
        //     example1.init();
        // </script>mns: ", this.options.editableColumns);

        //   //Extract felds
        //   this.options.editableColumns = this.options.editableColumns.split(',');
        // }
    }

    // --------------------------------------------------
    // -- Public Functions
    // --------------------------------------------------

    /**
     * Initializes the editable table. Creates the actions column.
     * @since 1.0.0
     */
    init() {
        this.table.find('thead tr').append('<th name="bstable-actions">' + 'Action' + '</th>');  // Append column to header
        this.table.find('tbody tr').append(this.actionsColumnHTML);

        this._addOnClickEventsToActions(); // Add onclick events to each action button in all rows

        // Process "addButton" parameter
        if (this.options.$addButton != null) {
            let _this = this;
            // Add a managed onclick event to the button
            this.options.$addButton.click(function () {
                _this._actionAddRow();
            });
        }
    }

    /**
     * Destroys the editable table. Removes the actions column.
     * @since 1.0.0
     */
    destroy() {
        this.table.find('th[name="bstable-actions"]').remove(); //remove header
        this.table.find('td[name="bstable-actions"]').remove(); //remove body rows
    }

    /**
     * Refreshes the editable table.
     *
     * Literally just removes and initializes the editable table again, wrapped in one function.
     * @since 1.0.0
     */
    refresh() {
        this.destroy();
        this.init();
    }

    // --------------------------------------------------
    // -- 'Static' Functions
    // --------------------------------------------------

    /**
     * Returns whether the provided row is currently being edited.
     *
     * @param {Object} row
     * @return {boolean} true if row is currently being edited.
     * @since 1.0.0
     */
    currentlyEditingRow($currentRow) {
        // Check if the row is currently being edited
        if ($currentRow.attr('data-status') == 'editing') {
            return true;
        } else {
            return false;
        }
    }

    // --------------------------------------------------
    // -- Button Mode Functions
    // --------------------------------------------------

    _actionsModeNormal(button) {
        $(button).parent().find('#bAcep').hide();
        $(button).parent().find('#bCanc').hide();
        $(button).parent().find('#bEdit').show();
        let $currentRow = $(button).parents('tr');         // get the row
        $currentRow.attr('data-status', '');               // remove editing status
    }

    _actionsModeEdit(button) {
        $(button).parent().find('#bAcep').show();
        $(button).parent().find('#bCanc').show();
        $(button).parent().find('#bEdit').hide();
        let $currentRow = $(button).parents('tr');         // get the row
        $currentRow.attr('data-status', 'editing');        // indicate the editing status
    }

    // --------------------------------------------------
    // -- Private Event Functions
    // --------------------------------------------------

    _rowEdit(button) {
        // Indicate user is editing the row
        let $currentRow = $(button).parents('tr');       // access the row
        console.log($currentRow);
        let $cols = $currentRow.find('td');              // read rows
        console.log($cols);
        if (this.currentlyEditingRow($currentRow)) return;    // not currently editing, return
        //Pone en modo de edición
        const arr = [];
        let numCount = 0;
        const map = new Map();
        let countCol = 0;
        this._modifyEachColumn(this.options.editableColumns, $cols, function ($td) {  // modify each column
            numCount++;
            let content = $td.html();             // read content
            if (numCount === 1 && content !== '') {
                console.log("Dieu Kien", content)
                dieuKienUpdate = content
            }
            if (content !== '' && content !== undefined && content !== null) {
                arr.push(content)
            }
            console.log("Arr", arr)
            if (arr.length === 0 || (numCount === 1 && content === '')) {
                command = 'INSERT'
            }
            if (arr.length !== 0 && (numCount === 1 && content !== '')) {
                command = 'UPDATE'
            }
            map.set("Col" + countCol++, content);
            let div = '<div style="display: none;">' + content + '</div>';  // hide content (save for later use)
            let input = '<input class="form-control input-sm"  data-original-value="' + content + '" value="' + content + '">';
            $td.html(div + input);                // set content
        });

        let dataSend = ''
        let num = 0;
        map.forEach(function (value, key, map) {
            num++;
            if (num < map.size) {
                dataSend += value + ","
            } else {
                dataSend += value
            }
        })
        contentBefore = dataSend;
        this._actionsModeEdit(button);
    }

    _rowAccept(button) {
        // Accept the changes to the row
        let thongbao = document.getElementById('thongbaoIdEmpty');
        let btnOK = document.getElementById('ok');
        let thongbaoError = document.getElementById('thongbaoError');
        let btnOKError = document.getElementById('okError');
        let $currentRow = $(button).parents('tr');    // access the row
        let currentTable = $(button).parents('table')[0].id
        let $cols = $currentRow.find('td');              // read fields
        if (!this.currentlyEditingRow($currentRow)) return;   // not currently editing, return

        // Finish editing the row & save edits
        // const arr = []
        const map = new Map();
        let count = 1;
        let numCount = 0;
        this._modifyEachColumn(this.options.editableColumns, $cols, function ($td) {  // modify each column
            let cont = $td.find('input').val();     // read through each input
            numCount++;
            if (numCount === 1 && cont === '') {
                // command = '';
                temp = 'NOT';
                thongbao.style.display = 'flex';
            }
            if (numCount === 1 && cont !== '') {
                temp = '';
            }
            if (cont === '') {
                map.set("Col" + count++, 'NULL');
            } else {
                map.set("Col" + count++, cont);
            }
            // arr.push(cont)
            $td.html(cont);                         // set the content and remove the input fields
        });
        btnOK.addEventListener('click', function () {
            thongbao.style.display = 'none';
        })
        btnOKError.addEventListener('click', function () {
            thongbaoError.style.display = 'none';
            window.open(window.location.href, '_self')
        })
        console.log(map)
        let dataSend = ''
        let num = 0;
        map.forEach(function (value, key, map) {
            num++;
            if (num < map.size) {
                dataSend += value + ","
            } else {
                dataSend += value
            }
        })
        console.log(command)
        if (temp !== 'NOT') {
            if (command === 'UPDATE') {
                $.ajax({
                    url: 'EditCustomer',
                    type: 'POST',
                    data: {
                        contentBefore: contentBefore,
                        send: dataSend,
                        currentTable: currentTable,
                        dieuKien: dieuKienUpdate
                    },
                    success: function (response) {
                        let mess = document.getElementById('message');
                        mess.innerHTML = response
                        thongbaoError.style.display = 'flex';
                    },
                    error: function () {
                    }
                });
            }
        }

        this._actionsModeNormal(button);
        this.options.onEdit($currentRow[0]);
    }

    _rowCancel(button) {
        // Reject the changes
        let $currentRow = $(button).parents('tr');       // access the row
        let $cols = $currentRow.find('td');              // read fields
        if (!this.currentlyEditingRow($currentRow)) return;   // not currently editing, return

        // Finish editing the row & delete changes
        this._modifyEachColumn(this.options.editableColumns, $cols, function ($td) {  // modify each column
            let cont = $td.find('div').html();    // read div content
            $td.html(cont);                       // set the content and remove the input fields
        });
        this._actionsModeNormal(button);
    }



    // --------------------------------------------------
    // -- Helper Functions
    // --------------------------------------------------

    _modifyEachColumn($editableColumns, $cols, howToModify) {
        // Go through each editable field and perform the howToModifyFunction function
        let n = 0;
        $cols.each(function () {
            n++;
            if ($(this).attr('name') == 'bstable-actions') return;    // exclude the actions column
            if (!isEditableColumn(n - 1)) return;                     // Check if the column is editable
            howToModify($(this));                                   // If editable, call the provided function
        });

        // console.log("Number of modified columns: " + n); // debug log


        function isEditableColumn(columnIndex) {
            // Indicates if the column is editable, based on configuration
            if ($editableColumns == null) {                           // option not defined
                return true;                                        // all columns are editable
            } else {                                                // option is defined
                //console.log('isEditableColumn: ' + columnIndex);  // DEBUG
                for (let i = 0; i < $editableColumns.length; i++) {
                    if (columnIndex == $editableColumns[i]) return true;
                }
                return false;  // column not found
            }
        }
    }

    _addOnClickEventsToActions() {
        let _this = this;
        // Add onclick events to each action button
        this.table.find('tbody tr #bEdit').each(function () {
            let button = this;
            button.onclick = function () {
                _this._rowEdit(button)
            }
        });
        this.table.find('tbody tr #bAcep').each(function () {
            let button = this;
            button.onclick = function () {
                _this._rowAccept(button)
            }
        });
        this.table.find('tbody tr #bCanc').each(function () {
            let button = this;
            button.onclick = function () {
                _this._rowCancel(button)
            }
        });
    }
}

