
    create table documentcatalog (
        id bigint not null,
        name_ varchar(50),
        date_ datetime,
        flag_ bit,
        authorId_ bigint,
        authorName_ varchar(50),
        type_ integer,
        content_ varchar(100),
        order_ integer,
        address_ varchar(200),
        parentId_ bigint,
        primary key (id)
    );

    create table documentitem (
        id bigint not null,
        name_ varchar(50),
        authorId_ bigint not null,
        authorName_ varchar(50),
        date_ datetime not null,
        realSize_ integer not null,
        size_ varchar(50) not null,
        randomName_ varchar(50) not null,
        type_ varchar(50) not null,
        documentCatalogId_ bigint,
        primary key (id)
    );

    create table users (
        id bigint not null,
        username_ varchar(50),
        password_ bigint,
        primary key (id)
    );

    alter table documentcatalog 
        add index FK78A52A9E28BD3E43 (parentId_), 
        add constraint FK78A52A9E28BD3E43 
        foreign key (parentId_) 
        references documentcatalog (id);

    alter table documentitem 
        add index FKA83A46AE49F267CF (documentCatalogId_), 
        add constraint FKA83A46AE49F267CF 
        foreign key (documentCatalogId_) 
        references documentcatalog (id);
