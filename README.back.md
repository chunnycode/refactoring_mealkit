# Java Spring framework를 이용한 밀키트 

## 0. 목차

[1. 개요](#1-개요)

[2. 기술](#2-기술)

[3. Use Case](#3-Use-Case)

[4. Flow Chart](#4-Flow-Chart)

[5. database ER Diagram](#5-database-er-diagram)

[6. 사이트 맵](#6-사이트-맵)

[7. 기능](#7-기능)

[8. 구현한 기능](#8-구현한-기능)

[9. 게시물 실행 영상](#9-게시물-실행-영상)

## 1. 개요

회원들이 자유롭게 판매자가 올린 밀키트를 주문하는 사이트입니다.

게시판으로는 공지사항/이벤트/1대1문의 게시판이 있습니다.

지도 항목은 다음주소api를 사용해 판매자의 위치를 확인할 수 있고 해당 판매자 클릭시 판매자의 판매 상품을 볼 수 있습니다.

결제는 카카오페이 api를 이용해 결제할 수 있습니다.

관리자는 기간별 상품 판매 통계를 확인할 수 있습니다.

## 2. 기술
1. Web Front : `HTML5` , `CSS`, `JavaScript`, `Jquery` , `Ajax`
2. Web Server :  `Tomcat`
3. DBMS : `Oracle DB`
4. 개발환경 : `Eclipse, Spring framework, Java`


## 3. Use Case
![image](https://user-images.githubusercontent.com/81474598/135708449-3c7f48d6-9cf6-4640-9a47-c5e11b4f90bd.png)


## 4. Flow Chart
![image](https://user-images.githubusercontent.com/81474598/135708462-7bce6caa-f6c0-4d37-a1e5-c322b1357e4e.png)


## 5. database ER Diagram
![캡처](https://user-images.githubusercontent.com/81474598/135708360-7d1501c2-e749-426b-b15a-4779d3728dac.png)


## 6. 사이트맵
![image](https://user-images.githubusercontent.com/81474598/135651292-d68b441d-7d2a-4df0-8643-ab00f277f77d.png)


## 7. 기능
프로젝트의 기능들 입니다.

1. 로그인/회원가입
2. 게시판 CRUD
3. 장바구니/결제
4. 마이페이지/배송시작/구매확정/반품
5. 구매 상품 리뷰 및 평점 주기
6. 기간별 통계 차트


## 8. 구현한 기능
제가 구현한 기능입니다.

1. 지도 - 카카오 지도 API를 활용하여 가게별 주소값으로 지도에 위치를 표시 (지도페이지, 상품 상세페이지)
2. 구매자 마이페이지 - 회원정보 및 주문내역 표시 (배송시작 / 구매확정 / 반품)
3. 구매자 마이페이지 - 배송 API를 활용하여 판매자가 입력한 운송장번호로 택배위치제공
4. 리뷰 페이지 - 구매확정시 리뷰작성이 가능하게함 (별점기능)  
5. 판매자 마이페이지 - 가게정보 및 구매자들의 주문내역 표시
6. 판매자 마이페이지 - 배송시작시 운송장번호를 입력하여 구매자들에게 제공
7. 메인 페이지 - 리뷰가 담긴 상품들중 상위 3개의 상품 추천
8. 결제 페이지 - 카카오페이 API를 활용하여 장바구니에 담긴 상품을 결제
9. 상품 상세페이지 - 상품정보와 판매자의 가게의 위치를 표시

## 9. 게시물 실행 영상
https://www.youtube.com/watch?v=31RXKdMCnCI
