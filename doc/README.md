## 个人博客开发

**sql语句**

```sql
#文件表
create table file
(
	id int auto_increment comment '主键id',
	name varchar(255) null comment '文件名',
	url varchar(255) null comment '文件url地址',
	type int null comment '文件类型',
	constraint file_pk
		primary key (id)
)
comment '文件表';
```

