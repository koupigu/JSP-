# JSP实训作业

## 项目部署

在/blog-jsp/src/jdbc/connect/DataBaseInfo.java 修改数据库配置信息

访问 http://localhost:8080/blog-jsp/index


## 前台页面展示

![首页](doc/image/首页.png)

![文章](doc/image/文章.png)

![文章详细]](doc/image/文章详细.png)

![标签](doc/image/标签.png)

## sql语句

- 文件表


```sql
create table file
(
	id int auto_increment,
	name varchar(255) null comment '名字',
	url varchar(255) null comment 'url地址',
	type int null comment '类型',
	constraint file_pk
		primary key (id)
)
comment '文件表';
```
