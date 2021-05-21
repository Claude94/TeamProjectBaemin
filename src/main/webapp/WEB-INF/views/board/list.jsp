<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>입점 업체 리스트</title>
    <link rel="stylesheet" href="/css/main.css" />
</head>

<body>


<div class="table-box">
            <table class="table list-table">
                <tbody>
                    <tr>
                        <th>매점번호</th>
                        <th>매점명</th>
                        <th>연락처</th>
                        <th>메뉴</th>
                        <th>카테고리</th>
                    </tr>

                    
                    <c:if test="${list.size() <= 0}">
                        <tr>
                            <td class="no-article" colspan="5">게시물이 존재하지 않습니다.</td>
                        </tr>
                    </c:if>

                    <c:if test="${list.size() > 0}">

                        <%-- 컨트롤러가 가져온 게시글 데이터를 반복하여 출력. --%>
                        <c:forEach var="restaurant" items="${list}">
                            <tr>
                                <td>${restaurant.restaurantNum}</td>
                                <td>${restaurant.restaurantName}</td>
                                <td>${restaurant.number}</td>
                                <td><a href="/board/content?restaurantNum=${restaurant.restaurantNum}">${restaurant.menus}</a></td>
                                <td>${restaurant.category}</td>
                            </tr>
                        </c:forEach>

                    </c:if>

                </tbody>
            </table>
        </div>

        <div class="list-btn">
            <a class="btn btn-basic" href="/board/write">글쓰기</a>
        </div>
    </div>



</body>

</html>