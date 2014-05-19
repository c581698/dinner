Ext.define("com.tp.performance.view.CoreBusiGrid", {
			extend : "com.dh.view.Grid",
			frame : true,

			constructor : function() {
				var me = this;

				me.plugins = [{
							clicksToEdit : 1,
							ptype : 'cellediting'
						}];

				me.features = [{
							ftype : 'groupingsummary',
							groupHeaderTpl : '{name}',
							hideGroupedHeader : true,
							enableGroupingMenu : false
						}];

				me.columns = [{
					text : 'Task',
					flex : 1,
					tdCls : 'task',
					sortable : true,
					dataIndex : 'description',
					hideable : false,
					summaryType : 'count',
					summaryRenderer : function(value, summaryData, dataIndex) {
						return ((value === 0 || value > 1) ? '(' + value
								+ ' Tasks)' : '(1 Task)');
					}
				}, {
					header : 'Project',
					width : 180,
					sortable : true,
					dataIndex : 'project'
				}, {
					header : 'Due Date',
					width : 80,
					sortable : true,
					dataIndex : 'due',
					summaryType : 'max',
					renderer : Ext.util.Format.dateRenderer('m/d/Y'),
					summaryRenderer : Ext.util.Format.dateRenderer('m/d/Y'),
					field : {
						xtype : 'datefield'
					}
				}, {
					header : 'Estimate',
					width : 75,
					sortable : true,
					dataIndex : 'estimate',
					summaryType : 'sum',
					renderer : function(value, metaData, record, rowIdx,
							colIdx, store, view) {
						return value + ' hours';
					},
					summaryRenderer : function(value, summaryData, dataIndex) {
						return value + ' hours';
					},
					field : {
						xtype : 'numberfield'
					}
				}, {
					header : 'Rate',
					width : 75,
					sortable : true,
					renderer : Ext.util.Format.usMoney,
					summaryRenderer : Ext.util.Format.usMoney,
					dataIndex : 'rate',
					summaryType : 'average',
					field : {
						xtype : 'numberfield'
					}
				}, {
					id : 'cost',
					header : 'Cost',
					width : 75,
					sortable : false,
					groupable : false,
					renderer : function(value, metaData, record, rowIdx,
							colIdx, store, view) {
						return Ext.util.Format.usMoney(record.get('estimate')
								* record.get('rate'));
					},
					dataIndex : 'cost',
					summaryType : function(records) {
						var i = 0, length = records.length, total = 0, record;

						for (; i < length; ++i) {
							record = records[i];
							total += record.get('estimate')
									* record.get('rate');
						}
						return total;
					},
					summaryRenderer : Ext.util.Format.usMoney
				}];

				me.callParent(arguments);
			}
		});