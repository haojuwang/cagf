
    create table task (
        id bigint not null,
        name_ varchar(50),
        description_ text,
        plannedStartDate_ datetime,
        plannedEndDate_ datetime,
        parentId_ bigint,
        primary key (id)
    );

    alter table task 
        add index FK36358556AFBE14 (parentId_), 
        add constraint FK36358556AFBE14 
        foreign key (parentId_) 
        references task (id);
