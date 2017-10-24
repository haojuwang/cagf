
    create table board (
        id bigint not null,
        name_ varchar(255),
        topicCount_ bigint,
        postCount_ bigint,
        primary key (id)
    );

    create table post (
        id bigint not null,
        authorId_ bigint,
        authorName_ varchar(50),
        date_ datetime,
        content_ varchar(255),
        parentId_ bigint,
        primary key (id)
    );

    create table topic (
        id bigint not null,
        title_ varchar(255),
        content_ bigint,
        authorId_ bigint,
        authorName_ varchar(50),
        date_ datetime,
        viewCount_ bigint,
        postCount_ bigint,
        lastDate_ datetime,
        lastAuthor_ varchar(50),
        parentId_ bigint,
        primary key (id)
    );

    alter table post 
        add index FK3498A09414AB4 (parentId_), 
        add constraint FK3498A09414AB4 
        foreign key (parentId_) 
        references topic (id);

    alter table topic 
        add index FK696CD2F8436C6B (parentId_), 
        add constraint FK696CD2F8436C6B 
        foreign key (parentId_) 
        references board (id);
