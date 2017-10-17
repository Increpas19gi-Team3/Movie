/* ȸ������_Member */
CREATE TABLE Member (
	MID VARCHAR2(20) NOT NULL, /* ID */
	Mpwd VARCHAR2(20), /* pwd */
	Mname VARCHAR2(50), /* name */
	Memail VARCHAR2(40), /* email */
	Mtel VARCHAR2(13), /* tel */
	Madmin CHAR(1) /* admin :0: ������, 1:����� */
);


CREATE UNIQUE INDEX PK_Member
	ON Member (
		MID ASC
	);

ALTER TABLE Member
	ADD
		CONSTRAINT PK_Member
		PRIMARY KEY (
			MID
		);

/* ��ȭ_Movie */
CREATE TABLE Movie (
	MCode VARCHAR2(3) NOT NULL, /* MCode */
	title VARCHAR2(50), /* title */
	price NUMBER(10), /* price */
	director VARCHAR2(20), /* director */
	actor VARCHAR2(20), /* actor */
	openDay DATE, /* openDay */
	genre VARCHAR2(20), /* genre */
	poster VARCHAR2(100), /* poster */
	synopsis VARCHAR2(3000), /* synopsis */
	startDay DATE, /* startDay */
	endDay DATE, /* endDay */
	Mcomment VARCHAR2(200), /* comment */
	appraisal CHAR(1) /* appraisal : 0~5 */
);


CREATE UNIQUE INDEX PK_Movie
	ON Movie (
		MCode ASC
	);

ALTER TABLE Movie
	ADD
		CONSTRAINT PK_Movie
		PRIMARY KEY (
			MCode
		);

/* ����_Theater */
CREATE TABLE Theater (
	TCode VARCHAR2(3) NOT NULL, /* TCode : T01 */
	Tname VARCHAR2(20), /* name */
	Tlocal VARCHAR2(200), /* local */
	Tdesc VARCHAR2(2000), /* desc */
	Timage VARCHAR2(100) /* image */
);


CREATE UNIQUE INDEX PK_Theater
	ON Theater (
		TCode ASC
	);

ALTER TABLE Theater
	ADD
		CONSTRAINT PK_Theater
		PRIMARY KEY (
			TCode
		);

/* ����_Reserve */
CREATE TABLE Reserve (
	RCode VARCHAR2(30) NOT NULL, /* RCode */
	MID VARCHAR2(20), /* ID */
	MCode VARCHAR2(3), /* MCode */
	SCode VARCHAR2(3), /* SCode */
	Rday DATE, /* Rday */
	Rturn CHAR(1), /* Rturn : 1, 2, 3 */
	Rtime DATE, /* Rtime : 12, 16, 20*/
	RSeat VARCHAR2(3) /* Seat */
);

CREATE UNIQUE INDEX PK_Reserve
	ON Reserve (
		RCode ASC
	);

ALTER TABLE Reserve
	ADD
		CONSTRAINT PK_Reserve
		PRIMARY KEY (
			RCode
		);

/* �󿵰�_Screening */
CREATE TABLE Screening (
	SCode VARCHAR2(3) NOT NULL, /* SCode : S01*/
	TCode VARCHAR2(3), /* TCode */
	SName VARCHAR2(20), /* SName */
	SseatCnt NUMBER(4), /* seatCnt */
	SseatInfo VARCHAR2(100), /* seatInfo : 25�¼� */
	Sturn VARCHAR2(50), /* turn  :1, 2, 3 ȸ�� */
	Stime VARCHAR2(50) /* time : 12, 16, 20 �� */
);


CREATE UNIQUE INDEX PK_Screening
	ON Screening (
		SCode ASC
	);

ALTER TABLE Screening
	ADD
		CONSTRAINT PK_Screening
		PRIMARY KEY (
			SCode
		);

/* �¼� ��Ȳ_Seat_25�ڸ�*3ȸ��*3�� */
CREATE TABLE Seat (
	Sseat CHAR(3), /* seat : A01 */
	Sdate DATE, /* date */
	Sturn CHAR(1), /* turn : 1, 2, 3 */
	Sstate CHAR(1) /* state : 0:���డ��, 1:����Ϸ� */
);


ALTER TABLE Reserve
	ADD
		CONSTRAINT FK_Movie_TO_Reserve
		FOREIGN KEY (
			MCode
		)
		REFERENCES Movie (
			MCode
		);

ALTER TABLE Reserve
	ADD
		CONSTRAINT FK_Screening_TO_Reserve
		FOREIGN KEY (
			SCode
		)
		REFERENCES Screening (
			SCode
		);

ALTER TABLE Reserve
	ADD
		CONSTRAINT FK_Member_TO_Reserve
		FOREIGN KEY (
			MID
		)
		REFERENCES Member (
			MID
		);

ALTER TABLE Screening
	ADD
		CONSTRAINT FK_Theater_TO_Screening
		FOREIGN KEY (
			TCode
		)
		REFERENCES Theater (
			TCode
		);



--------------- ������ ����
-- ���� ����
INSERT INTO THEATER VALUES(
    'T01', '���CGV', '����Ư���� ��걸 �Ѱ���� 23��', 
    '���������� 2,500����! ���ѹα� ���� ������ �̿��� CGV ������ NO.1 ����',
    'null.png');
 

-- ȸ������ �Է�
INSERT INTO MEMBER VALUES('son', '1234', '�հ���', 'son@mail.com', '010-111-1111', '0');
INSERT INTO MEMBER VALUES('han', '1234', '�ѹ���', 'han@mail.com', '010-222-1111', '1');

-- �󿵰� ���� 
INSERT INTO SCREENING VALUES('S01', 'T01', 'IMAX', '25', '��� �������ͷ� �ǹ���ũ���� �����Ͽ� ��� ������ ȭ�� ����',
'1,2,3', '12, 16, 20')


-- �¼� ����
INSERT INTO SEAT VALUES('A01', sysdate, '1', '0')


-- ��ȭ ����
INSERT INTO MOVIE VALUES('A01', 
'������',  10000, '���¿�', '������', SYSDATE,
'Action', 'movie1.jpg',
'�Ŵ��� ������ ���� ������ ����� ���� ������.
 �� ���� �����ϴ� ������ ��� �������� �ҹ�����ŷ���Ҹ� �����ϴ� �� �����Ҹ�, �������� �������� �ʴ� �ϸ� ����Ʈ�� ��п�� ǥ������ ���縦 �˰� �ȴ�. ���� ��ü�� �������� ���� �ڸ� �Ѵ� �������� �� ���Ŀ� ������ ��û�� ������ ���� �˰� �Ǹ鼭 ������ �� ���� ���⿡ ������.
 ���� ǥ������ �����ϰ� �������� ����ϱ� ���� �İߵ� ������� ���� �Ƴ� ������ �ݿ��ڷ� ���ư��� �̸� ���̷� ������ ���̰�, ǥ������ ��� �Ϳ� ������ ���Ѵ�. ǥ������ ������� ���� �ӿ��� �������� ���˸� �����ϱ� ���ؼ� �׳ฦ �����ϰ� ������, ����ġ ���� �Ƴ��� ����� �˰� �Ǹ鼭 ȥ���� �۽��̰� �Ǵµ�...',
 sysdate, '2017-10-20', '', '3');