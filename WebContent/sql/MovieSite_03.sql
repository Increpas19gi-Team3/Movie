
/* 회원관리_Member */
CREATE TABLE Member (
	MID VARCHAR2(20) NOT NULL, /* MID */
	Mpwd VARCHAR2(20), /* Mpwd */
	Mname VARCHAR2(50), /* Mname */
	Memail VARCHAR2(40), /* Memail */
	Mtel VARCHAR2(13), /* Mtel */
	Madmin CHAR(1) /* Madmin - 0: 관리자, 1:사용자 */
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

/* 영화_Movie */
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
	appraisal CHAR(1) /* appraisal - 0~5*/
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

/* 극장_Theater */
CREATE TABLE Theater (
	TCode VARCHAR2(3) NOT NULL, /* TCode -T01 */
	Tname VARCHAR2(20), /* Tname */
	Tlocal VARCHAR2(200), /* Tlocal */
	Tdesc VARCHAR2(2000), /* Tdesc */
	Timage VARCHAR2(100) /* Timage */
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


/* 예약_Reserve */
CREATE TABLE Reserve (
	RCode VARCHAR2(30) NOT NULL, /* RCode */
	MID VARCHAR2(20), /* MID */
	MCode VARCHAR2(3), /* MCode */
	SCode VARCHAR2(3), /* SCode */
	Rday DATE, /* Rday */
	Rturn CHAR(1), /* Rturn */
	Rtime VARCHAR2(5), /* Rtime : 12시 or 16시 or 20시*/
	RSeat VARCHAR2(100) /* RSeat */
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

/* 상영관_Screening */
CREATE TABLE Screening (
	SCode VARCHAR2(3) NOT NULL, /* SCode - S01*/
	TCode VARCHAR2(3), /* TCode */
	SName VARCHAR2(20), /* SName */
	SseatCnt NUMBER(4), /* SseatCnt */
	SseatInfo VARCHAR2(100), /* SseatInfo - '25좌석'*/
	Sturn VARCHAR2(50), /* Sturn - 1, 2, 3 회차*/
	Stime VARCHAR2(50) /* Stime - 12, 16, 20 시*/
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

/* 좌석 현황_Seat_25자리*3회차*3일 */
CREATE TABLE Seat (
	Sseat CHAR(3), /* Sseat */
	Sdate DATE, /* Sdate */
	Sturn CHAR(1), /* Sturn - 1, 2, 3*/
	Sstate CHAR(1) /* Sstate - 0:예약가능, 1:예약완료*/
);



/* ScreenTurn_상영회차 */
CREATE TABLE ScreenTurn (
	SCode VARCHAR2(3), /* SCode */
	MCode VARCHAR2(3), /* MCode */
	STturn CHAR(1), /* STturn */
	STdate DATE /* STdate */
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

ALTER TABLE ScreenTurn
	ADD
		CONSTRAINT FK_Screening_TO_ScreenTurn
		FOREIGN KEY (
			SCode
		)
		REFERENCES Screening (
			SCode
		);

ALTER TABLE ScreenTurn
	ADD
		CONSTRAINT FK_Movie_TO_ScreenTurn
		FOREIGN KEY (
			MCode
		)
		REFERENCES Movie (
			MCode
		);




--------------- 데이터 삽입
-- 극장 정보
INSERT INTO THEATER VALUES(
    'T01', '용산CGV', '서울특별시 용산구 한강대로 23길', 
    '누적관람객 2,500만명! 대한민국 국민 절반이 이용한 CGV 관람객 NO.1 극장',
    'cvgImg.png');


-- 회원정보 입력
INSERT INTO MEMBER VALUES('son', '1234', '손가연', 'son@mail.com', '010-111-1111', '0');
INSERT INTO MEMBER VALUES('han', '1234', '한범석', 'han@mail.com', '010-222-1111', '1');

-- 상영관 정보 
INSERT INTO SCREENING VALUES('S01', 'T01', 'IMAX', '25', '듀얼 프로젝터로 실버스크린에 송출하여 밝고 선명한 화질 제공','1,2,3', '12, 16, 20');



-- 예매 내역 등록
insert into reserve values('R01', 'han', 'M01', 'S01', sysdate, '1', '12시', 'A01');


-- 영화 정보
INSERT INTO MOVIE VALUES('M01', '남한산성',  8000, '황동혁', '김윤석', SYSDATE,'역사', 'TheaterImg.png',
'거대한 국제적 음모가 숨겨진 운명의 도시 베를린. 그 곳에 상주하는 국정원 요원 정진수는 불법무기거래장소를 감찰하던 중 국적불명, 지문마저 감지되지 않는 일명 ‘고스트’ 비밀요원 표종성의 존재를 알게 된다. 그의 정체를 밝혀내기 위해 뒤를 쫓던 정진수는 그 배후에 숨겨진 엄청난 국제적 음모를 알게 되면서 걷잡을 수 없는 위기에 빠진다.
 한편 표종성을 제거하고 베를린을 장악하기 위해 파견된 동명수는 그의 아내 연정희를 반역자로 몰아가며 이를 빌미로 숨통을 조이고, 표종성의 모든 것에 위협을 가한다. 표종성은 동명수의 협박 속에서 연정희의 무죄를 증명하기 위해서 그녀를 미행하게 되지만, 예상치 못한 아내의 비밀을 알게 되면서 혼란에 휩싸이게 되는데...',
 SYSDATE, '2017-11-15', '3');

INSERT INTO MOVIE VALUES('M02', 
'대장 김창수',  10000, '이원태', '조진웅', SYSDATE,
'드라마', 'TheaterImg.png',
'대장 김창수 김창수 김창수',
 SYSDATE, '2017-11-20', '3');
 
 INSERT INTO MOVIE VALUES('M03', 
'범죄도시',  12000, '강윤성', '마동석', SYSDATE,
'액션', 'TheaterImg.png',
'범죄도시범죄도시범죄도시범죄도시범죄도시범죄도시',
 SYSDATE, '2017-10-22', '3');
 
 INSERT INTO MOVIE VALUES('M04', 
'부산행',  15000, '홍길동', '공유', SYSDATE,
'공포', 'TheaterImg.png',
'부산행 좀비부산행 좀비부산행 좀비부산행 좀비부산행 좀비부산행 좀비',
 SYSDATE, '2017-10-21', '3');
 
 
 INSERT INTO MOVIE VALUES('M05', 
'베를린',  10000, '류승완', '하정우', SYSDATE,
'액션', 'TheaterImg.png',
'거대한 국제적 음모가 숨겨진 운명의 도시 베를린.
 그 곳에 상주하는 국정원 요원 정진수는 불법무기거래장소를 감찰하던 중 국적불명, 지문마저 감지되지 않는 일명 ‘고스트’ 비밀요원 표종성의 존재를 알게 된다. 그의 정체를 밝혀내기 위해 뒤를 쫓던 정진수는 그 배후에 숨겨진 엄청난 국제적 음모를 알게 되면서 걷잡을 수 없는 위기에 빠진다.
 한편 표종성을 제거하고 베를린을 장악하기 위해 파견된 동명수는 그의 아내 연정희를 반역자로 몰아가며 이를 빌미로 숨통을 조이고, 표종성의 모든 것에 위협을 가한다. 표종성은 동명수의 협박 속에서 연정희의 무죄를 증명하기 위해서 그녀를 미행하게 되지만, 예상치 못한 아내의 비밀을 알게 되면서 혼란에 휩싸이게 되는데...',
 SYSDATE, '2017-10-20', '3');



-- 상영 회차 등록
insert into screenturn values('S01', 'M01', '1', sysdate);
insert into screenturn values('S01', 'M02', '2', sysdate);
insert into screenturn values('S01', 'M01', '3', sysdate);
insert into screenturn values('S01', 'M01', '1', sysdate+1);
insert into screenturn values('S01', 'M02', '2', sysdate+1);
insert into screenturn values('S01', 'M01', '3', sysdate+1);
insert into screenturn values('S01', 'M01', '1', sysdate+2);
insert into screenturn values('S01', 'M02', '2', sysdate+2);
insert into screenturn values('S01', 'M01', '3', sysdate+2);

-- 예매 내역 등록
insert into reserve values('R01', 'han', 'M01', 'S01', sysdate, '1', '12시', 'A01');


---- 예약 좌석 관련 쿼리

insert into seat VALUEs ('A01', sysdate, '1', '1');
insert into seat VALUEs ('A02', sysdate, '1', '0');
insert into seat VALUEs ('A03', sysdate, '1', '0');
insert into seat VALUEs ('A04', sysdate, '1', '0');
insert into seat VALUEs ('A05', sysdate, '1', '0');
insert into seat VALUEs ('B01', sysdate, '1', '0');
insert into seat VALUEs ('B02', sysdate, '1', '0');
insert into seat VALUEs ('B03', sysdate, '1', '0');
insert into seat VALUEs ('B04', sysdate, '1', '0');
insert into seat VALUEs ('B05', sysdate, '1', '0');
insert into seat VALUEs ('C01', sysdate, '1', '0');
insert into seat VALUEs ('C02', sysdate, '1', '0');
insert into seat VALUEs ('C03', sysdate, '1', '0');
insert into seat VALUEs ('C04', sysdate, '1', '0');
insert into seat VALUEs ('C05', sysdate, '1', '0');
insert into seat VALUEs ('D01', sysdate, '1', '0');
insert into seat VALUEs ('D02', sysdate, '1', '0');
insert into seat VALUEs ('D03', sysdate, '1', '0');
insert into seat VALUEs ('D04', sysdate, '1', '0');
insert into seat VALUEs ('D05', sysdate, '1', '0');
insert into seat VALUEs ('E01', sysdate, '1', '0');
insert into seat VALUEs ('E02', sysdate, '1', '0');
insert into seat VALUEs ('E03', sysdate, '1', '0');
insert into seat VALUEs ('E04', sysdate, '1', '0');
insert into seat VALUEs ('E05', sysdate, '1', '0');
insert into seat VALUEs ('A01', sysdate, '2', '0');
insert into seat VALUEs ('A02', sysdate, '2', '0');
insert into seat VALUEs ('A03', sysdate, '2', '0');
insert into seat VALUEs ('A04', sysdate, '2', '0');
insert into seat VALUEs ('A05', sysdate, '2', '0');
insert into seat VALUEs ('B01', sysdate, '2', '0');
insert into seat VALUEs ('B02', sysdate, '2', '0');
insert into seat VALUEs ('B03', sysdate, '2', '0');
insert into seat VALUEs ('B04', sysdate, '2', '0');
insert into seat VALUEs ('B05', sysdate, '2', '0');
insert into seat VALUEs ('C01', sysdate, '2', '0');
insert into seat VALUEs ('C02', sysdate, '2', '0');
insert into seat VALUEs ('C03', sysdate, '2', '0');
insert into seat VALUEs ('C04', sysdate, '2', '0');
insert into seat VALUEs ('C05', sysdate, '2', '0');
insert into seat VALUEs ('D01', sysdate, '2', '0');
insert into seat VALUEs ('D02', sysdate, '2', '0');
insert into seat VALUEs ('D03', sysdate, '2', '0');
insert into seat VALUEs ('D04', sysdate, '2', '0');
insert into seat VALUEs ('D05', sysdate, '2', '0');
insert into seat VALUEs ('E01', sysdate, '2', '0');
insert into seat VALUEs ('E02', sysdate, '2', '0');
insert into seat VALUEs ('E03', sysdate, '2', '0');
insert into seat VALUEs ('E04', sysdate, '2', '0');
insert into seat VALUEs ('E05', sysdate, '2', '0');
insert into seat VALUEs ('A01', sysdate, '3', '0');
insert into seat VALUEs ('A02', sysdate, '3', '0');
insert into seat VALUEs ('A03', sysdate, '3', '0');
insert into seat VALUEs ('A04', sysdate, '3', '0');
insert into seat VALUEs ('A05', sysdate, '3', '0');
insert into seat VALUEs ('B01', sysdate, '3', '0');
insert into seat VALUEs ('B02', sysdate, '3', '0');
insert into seat VALUEs ('B03', sysdate, '3', '0');
insert into seat VALUEs ('B04', sysdate, '3', '0');
insert into seat VALUEs ('B05', sysdate, '3', '0');
insert into seat VALUEs ('C01', sysdate, '3', '0');
insert into seat VALUEs ('C02', sysdate, '3', '0');
insert into seat VALUEs ('C03', sysdate, '3', '0');
insert into seat VALUEs ('C04', sysdate, '3', '0');
insert into seat VALUEs ('C05', sysdate, '3', '0');
insert into seat VALUEs ('D01', sysdate, '3', '0');
insert into seat VALUEs ('D02', sysdate, '3', '0');
insert into seat VALUEs ('D03', sysdate, '3', '0');
insert into seat VALUEs ('D04', sysdate, '3', '0');
insert into seat VALUEs ('D05', sysdate, '3', '0');
insert into seat VALUEs ('E01', sysdate, '3', '0');
insert into seat VALUEs ('E02', sysdate, '3', '0');
insert into seat VALUEs ('E03', sysdate, '3', '0');
insert into seat VALUEs ('E04', sysdate, '3', '0');
insert into seat VALUEs ('E05', sysdate, '3', '0');



insert into seat VALUEs ('A01', sysdate+1, '1', '0');
insert into seat VALUEs ('A02', sysdate+1, '1', '0');
insert into seat VALUEs ('A03', sysdate+1, '1', '0');
insert into seat VALUEs ('A04', sysdate+1, '1', '0');
insert into seat VALUEs ('A05', sysdate+1, '1', '0');
insert into seat VALUEs ('B01', sysdate+1, '1', '0');
insert into seat VALUEs ('B02', sysdate+1, '1', '0');
insert into seat VALUEs ('B03', sysdate+1, '1', '0');
insert into seat VALUEs ('B04', sysdate+1, '1', '0');
insert into seat VALUEs ('B05', sysdate+1, '1', '0');
insert into seat VALUEs ('C01', sysdate+1, '1', '0');
insert into seat VALUEs ('C02', sysdate+1, '1', '0');
insert into seat VALUEs ('C03', sysdate+1, '1', '0');
insert into seat VALUEs ('C04', sysdate+1, '1', '0');
insert into seat VALUEs ('C05', sysdate+1, '1', '0');
insert into seat VALUEs ('D01', sysdate+1, '1', '0');
insert into seat VALUEs ('D02', sysdate+1, '1', '0');
insert into seat VALUEs ('D03', sysdate+1, '1', '0');
insert into seat VALUEs ('D04', sysdate+1, '1', '0');
insert into seat VALUEs ('D05', sysdate+1, '1', '0');
insert into seat VALUEs ('E01', sysdate+1, '1', '0');
insert into seat VALUEs ('E02', sysdate+1, '1', '0');
insert into seat VALUEs ('E03', sysdate+1, '1', '0');
insert into seat VALUEs ('E04', sysdate+1, '1', '0');
insert into seat VALUEs ('E05', sysdate+1, '1', '0');
insert into seat VALUEs ('A01', sysdate+1, '2', '0');
insert into seat VALUEs ('A02', sysdate+1, '2', '0');
insert into seat VALUEs ('A03', sysdate+1, '2', '0');
insert into seat VALUEs ('A04', sysdate+1, '2', '0');
insert into seat VALUEs ('A05', sysdate+1, '2', '0');
insert into seat VALUEs ('B01', sysdate+1, '2', '0');
insert into seat VALUEs ('B02', sysdate+1, '2', '0');
insert into seat VALUEs ('B03', sysdate+1, '2', '0');
insert into seat VALUEs ('B04', sysdate+1, '2', '0');
insert into seat VALUEs ('B05', sysdate+1, '2', '0');
insert into seat VALUEs ('C01', sysdate+1, '2', '0');
insert into seat VALUEs ('C02', sysdate+1, '2', '0');
insert into seat VALUEs ('C03', sysdate+1, '2', '0');
insert into seat VALUEs ('C04', sysdate+1, '2', '0');
insert into seat VALUEs ('C05', sysdate+1, '2', '0');
insert into seat VALUEs ('D01', sysdate+1, '2', '0');
insert into seat VALUEs ('D02', sysdate+1, '2', '0');
insert into seat VALUEs ('D03', sysdate+1, '2', '0');
insert into seat VALUEs ('D04', sysdate+1, '2', '0');
insert into seat VALUEs ('D05', sysdate+1, '2', '0');
insert into seat VALUEs ('E01', sysdate+1, '2', '0');
insert into seat VALUEs ('E02', sysdate+1, '2', '0');
insert into seat VALUEs ('E03', sysdate+1, '2', '0');
insert into seat VALUEs ('E04', sysdate+1, '2', '0');
insert into seat VALUEs ('E05', sysdate+1, '2', '0');
insert into seat VALUEs ('A01', sysdate+1, '3', '0');
insert into seat VALUEs ('A02', sysdate+1, '3', '0');
insert into seat VALUEs ('A03', sysdate+1, '3', '0');
insert into seat VALUEs ('A04', sysdate+1, '3', '0');
insert into seat VALUEs ('A05', sysdate+1, '3', '0');
insert into seat VALUEs ('B01', sysdate+1, '3', '0');
insert into seat VALUEs ('B02', sysdate+1, '3', '0');
insert into seat VALUEs ('B03', sysdate+1, '3', '0');
insert into seat VALUEs ('B04', sysdate+1, '3', '0');
insert into seat VALUEs ('B05', sysdate+1, '3', '0');
insert into seat VALUEs ('C01', sysdate+1, '3', '0');
insert into seat VALUEs ('C02', sysdate+1, '3', '0');
insert into seat VALUEs ('C03', sysdate+1, '3', '0');
insert into seat VALUEs ('C04', sysdate+1, '3', '0');
insert into seat VALUEs ('C05', sysdate+1, '3', '0');
insert into seat VALUEs ('D01', sysdate+1, '3', '0');
insert into seat VALUEs ('D02', sysdate+1, '3', '0');
insert into seat VALUEs ('D03', sysdate+1, '3', '0');
insert into seat VALUEs ('D04', sysdate+1, '3', '0');
insert into seat VALUEs ('D05', sysdate+1, '3', '0');
insert into seat VALUEs ('E01', sysdate+1, '3', '0');
insert into seat VALUEs ('E02', sysdate+1, '3', '0');
insert into seat VALUEs ('E03', sysdate+1, '3', '0');
insert into seat VALUEs ('E04', sysdate+1, '3', '0');
insert into seat VALUEs ('E05', sysdate+1, '3', '0');



insert into seat VALUEs ('A01', sysdate+2, '1', '0');
insert into seat VALUEs ('A02', sysdate+2, '1', '0');
insert into seat VALUEs ('A03', sysdate+2, '1', '0');
insert into seat VALUEs ('A04', sysdate+2, '1', '0');
insert into seat VALUEs ('A05', sysdate+2, '1', '0');
insert into seat VALUEs ('B01', sysdate+2, '1', '0');
insert into seat VALUEs ('B02', sysdate+2, '1', '0');
insert into seat VALUEs ('B03', sysdate+2, '1', '0');
insert into seat VALUEs ('B04', sysdate+2, '1', '0');
insert into seat VALUEs ('B05', sysdate+2, '1', '0');
insert into seat VALUEs ('C01', sysdate+2, '1', '0');
insert into seat VALUEs ('C02', sysdate+2, '1', '0');
insert into seat VALUEs ('C03', sysdate+2, '1', '0');
insert into seat VALUEs ('C04', sysdate+2, '1', '0');
insert into seat VALUEs ('C05', sysdate+2, '1', '0');
insert into seat VALUEs ('D01', sysdate+2, '1', '0');
insert into seat VALUEs ('D02', sysdate+2, '1', '0');
insert into seat VALUEs ('D03', sysdate+2, '1', '0');
insert into seat VALUEs ('D04', sysdate+2, '1', '0');
insert into seat VALUEs ('D05', sysdate+2, '1', '0');
insert into seat VALUEs ('E01', sysdate+2, '1', '0');
insert into seat VALUEs ('E02', sysdate+2, '1', '0');
insert into seat VALUEs ('E03', sysdate+2, '1', '0');
insert into seat VALUEs ('E04', sysdate+2, '1', '0');
insert into seat VALUEs ('E05', sysdate+2, '1', '0');
insert into seat VALUEs ('A01', sysdate+2, '2', '0');
insert into seat VALUEs ('A02', sysdate+2, '2', '0');
insert into seat VALUEs ('A03', sysdate+2, '2', '0');
insert into seat VALUEs ('A04', sysdate+2, '2', '0');
insert into seat VALUEs ('A05', sysdate+2, '2', '0');
insert into seat VALUEs ('B01', sysdate+2, '2', '0');
insert into seat VALUEs ('B02', sysdate+2, '2', '0');
insert into seat VALUEs ('B03', sysdate+2, '2', '0');
insert into seat VALUEs ('B04', sysdate+2, '2', '0');
insert into seat VALUEs ('B05', sysdate+2, '2', '0');
insert into seat VALUEs ('C01', sysdate+2, '2', '0');
insert into seat VALUEs ('C02', sysdate+2, '2', '0');
insert into seat VALUEs ('C03', sysdate+2, '2', '0');
insert into seat VALUEs ('C04', sysdate+2, '2', '0');
insert into seat VALUEs ('C05', sysdate+2, '2', '0');
insert into seat VALUEs ('D01', sysdate+2, '2', '0');
insert into seat VALUEs ('D02', sysdate+2, '2', '0');
insert into seat VALUEs ('D03', sysdate+2, '2', '0');
insert into seat VALUEs ('D04', sysdate+2, '2', '0');
insert into seat VALUEs ('D05', sysdate+2, '2', '0');
insert into seat VALUEs ('E01', sysdate+2, '2', '0');
insert into seat VALUEs ('E02', sysdate+2, '2', '0');
insert into seat VALUEs ('E03', sysdate+2, '2', '0');
insert into seat VALUEs ('E04', sysdate+2, '2', '0');
insert into seat VALUEs ('E05', sysdate+2, '2', '0');
insert into seat VALUEs ('A01', sysdate+2, '3', '0');
insert into seat VALUEs ('A02', sysdate+2, '3', '0');
insert into seat VALUEs ('A03', sysdate+2, '3', '0');
insert into seat VALUEs ('A04', sysdate+2, '3', '0');
insert into seat VALUEs ('A05', sysdate+2, '3', '0');
insert into seat VALUEs ('B01', sysdate+2, '3', '0');
insert into seat VALUEs ('B02', sysdate+2, '3', '0');
insert into seat VALUEs ('B03', sysdate+2, '3', '0');
insert into seat VALUEs ('B04', sysdate+2, '3', '0');
insert into seat VALUEs ('B05', sysdate+2, '3', '0');
insert into seat VALUEs ('C01', sysdate+2, '3', '0');
insert into seat VALUEs ('C02', sysdate+2, '3', '0');
insert into seat VALUEs ('C03', sysdate+2, '3', '0');
insert into seat VALUEs ('C04', sysdate+2, '3', '0');
insert into seat VALUEs ('C05', sysdate+2, '3', '0');

insert into seat VALUEs ('D01', sysdate+2, '3', '0');
insert into seat VALUEs ('D02', sysdate+2, '3', '0');
insert into seat VALUEs ('D03', sysdate+2, '3', '0');
insert into seat VALUEs ('D04', sysdate+2, '3', '0');
insert into seat VALUEs ('D05', sysdate+2, '3', '0');
insert into seat VALUEs ('E01', sysdate+2, '3', '0');
insert into seat VALUEs ('E02', sysdate+2, '3', '0');
insert into seat VALUEs ('E03', sysdate+2, '3', '0');
insert into seat VALUEs ('E04', sysdate+2, '3', '0');
insert into seat VALUEs ('E05', sysdate+2, '3', '0');
