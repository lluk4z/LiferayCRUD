create table MP_Task (
	taskId LONG not null primary key,
	title VARCHAR(75) null,
	description VARCHAR(75) null,
	completed BOOLEAN,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);