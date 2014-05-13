Ext.define("com.tp.view.AttachmentView", {
			extend : "com.tp.app.BaseGrid",
			requires : ["com.tp.store.Attachment"],
			title : "Attachment",
			constructor : function() {
				var me = this;
				me.columns = [{
							dataIndex : "fileId",
							header : "记录ID，主键"
						}, {
							dataIndex : "fileName",
							header : "文件原始名"
						}, {
							dataIndex : "fileOutName",
							header : "附件系统生成的名称"
						}, {
							dataIndex : "fileExt",
							header : "附件扩展名"
						}, {
							dataIndex : "filePath",
							header : "文件路径"
						}, {
							dataIndex : "attachmentType",
							header : "附件所属类型"
						}, {
							dataIndex : "refId",
							header : "附件所属对象编号"
						}, {
							dataIndex : "createDate",
							header : "附件上传时间"
						}, {
							dataIndex : "creator",
							header : "附件上传人编号person_id"
						}];
				me.store = Ext.create("com.tp.store.Attachment");
				me.callParent(arguments);
			}
		});