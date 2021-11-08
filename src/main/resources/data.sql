drop table if exists ARTICLE;

CREATE TABLE if not exists ARTICLE (
       id int auto_increment not null primary key,
       TITLE varchar,
       BODY varchar
);

insert into ARTICLE (title, body)
VALUES ( 'title_title','ArticleBody_ArticleBody_ArticleBody_\nArticleBody_ArticleBody_ArticleBody_' ),
       ( 'title_title','ArticleBody_ArticleBody_ArticleBody_\nArticleBody_ArticleBody_ArticleBody_' ),
       ( 'title_title','ArticleBody_ArticleBody_ArticleBody_\nArticleBody_ArticleBody_ArticleBody_' ),
       ( 'title_title','ArticleBody_ArticleBody_ArticleBody_\nArticleBody_ArticleBody_ArticleBody_' ),
       ( 'title_title','ArticleBody_ArticleBody_ArticleBody_\nArticleBody_ArticleBody_ArticleBody_' ),
       ( 'title_title','ArticleBody_ArticleBody_ArticleBody_\nArticleBody_ArticleBody_ArticleBody_' ),
       ( 'title_title','ArticleBody_ArticleBody_ArticleBody_\nArticleBody_ArticleBody_ArticleBody_' );
