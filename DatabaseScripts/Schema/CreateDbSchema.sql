create table [dbo].[Key]
(keyId INT IDENTITY(1,1) NOT NULL,
keyToken NVARCHAR(255) NOT NULL,
CONSTRAINT [PK_KEY] PRIMARY KEY CLUSTERED 
(
keyId ASC
)
)

create table [dbo].[User](
 userId INT IDENTITY(1,1) NOT NULL,
 username NVARCHAR(25) NOT NULL,
 password NVARCHAR(255) NOT NULL,
 keyId INT NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED
 (
 userId ASC
 ),
	CONSTRAINT [FK_User_Key] 
		FOREIGN KEY (keyId) REFERENCES dbo.[Key](keyId)
)


create table [dbo].[Role](
 roleId INT IDENTITY(1,1) NOT NULL,
 roleDesc NVARCHAR(255) NOT NULL
 CONSTRAINT [PK_Role] PRIMARY KEY CLUSTERED
 (
 roleId ASC
 )	
)

create table [dbo].[DoorGroup](
 doorGroupId INT IDENTITY(1,1) NOT NULL,
 doorGroupDesc NVARCHAR(255) NOT NULL,
 CONSTRAINT [PK_DoorGroup] PRIMARY KEY CLUSTERED
 (
 doorGroupId ASC
 )
)

create table [dbo].[Door](
 doorId INT IDENTITY(1,1) NOT NULL,
 doorDesc NVARCHAR(255) NOT NULL,
 doorToken NVARCHAR(255) NOT NULL,
 CONSTRAINT [PK_Door] PRIMARY KEY CLUSTERED
 (
 doorId ASC
 )
)

create table [dbo].[UserRole](
 userId INT NOT NULL,
 roleId INT NOT NULL
 CONSTRAINT [PK_UserRole] PRIMARY KEY CLUSTERED
 (
 userId,roleId ASC
 ),
	CONSTRAINT [FK_UserRole_User] 
		FOREIGN KEY (userId) REFERENCES dbo.[User](userId),
	CONSTRAINT [FK_UserRole_Role] 
		FOREIGN KEY (roleId) REFERENCES dbo.[Role](roleId)
)

create table [dbo].[DoorGroupDoor](
 doorGroupId INT NOT NULL,
 doorId INT NOT NULL
 CONSTRAINT [PK_DoorGroupDoor] PRIMARY KEY CLUSTERED
 (
 doorGroupId,doorId ASC
 ),
	CONSTRAINT [FK_DoorGroupDoor_DoorGroup] 
		FOREIGN KEY (doorGroupId) REFERENCES dbo.[DoorGroup](doorGroupId),
	CONSTRAINT [FK_DoorGroupDoor_Door] 
		FOREIGN KEY (doorId) REFERENCES dbo.[Door](doorId)
)

create table [dbo].[DoorGroupRole](
 doorGroupId INT NOT NULL,
 roleId INT NOT NULL
 CONSTRAINT [PK_DoorGroupRole] PRIMARY KEY CLUSTERED
 (
 doorGroupId,roleId ASC
 ),
	CONSTRAINT [FK_DoorGroupRole_DoorGroup] 
		FOREIGN KEY (doorGroupId) REFERENCES dbo.[DoorGroup](doorGroupId),
	CONSTRAINT [FK_DoorGroupRole_Role] 
		FOREIGN KEY (roleId) REFERENCES dbo.[Role](roleId)
)