#前台dao


主要负责前台jsp页面填充数据的获取

**负责人：蒋超辉**

###主要涉及的sql
####文章

- 文章分页按最新时间排序

``` sql
  select * from article order by a_publish_time desc LIMIT ?,?
```
  

- 根据id查找文章

``` sql
  select * from article where id=?
```

- 获取最新?篇文章

``` sql
  select * from article order by a_publish_time desc LIMIT ?
```

- 浏览数加一

```sql
  UPDATE article SET a_page_view = 100 WHERE a_id = 20190017
```

  

####分类

- 查询所有分类

``` sql
  select c_name from category
```

  

- 根据分类id查找所有文章分页

``` sql
  select * from article where a_category_id = 20190001 LIMIT ?,?
```



####标签

- 获取文章数最多的标签（前3个）

``` sql
  select * from tag  ORDER BY t_count desc LIMIT 10
```

  

- 根据标签id查找所有文章分页

``` sql
  SELECT * FROM article WHERE a_id in (SELECT relationship_a_id FROM tag_relationship WHERE relationship_t_id = 2 )
```

- 根据文章id查找同标签的文章（不包含自身）

```sql
  SELECT * FROM article where a_id in (
	SELECT relationship_a_id FROM tag_relationship WHERE relationship_t_id in (
		SELECT relationship_t_id FROM tag_relationship where relationship_a_id = 20190096
     ) AND a_id != 20190096
  )
```
  