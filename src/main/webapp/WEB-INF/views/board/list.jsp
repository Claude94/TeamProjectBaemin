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

    <div class="wrap">
        <h1>입점 업체 리스트</h1>


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

                        <c:forEach var="restaurant" items="${list}">
                            <tr>
                                <td>${restaurant.restaurantNum}</td>
                                <td>${restaurant.restaurantName}</td>
                                <td>${restaurant.number}</td>
                                <td><a
                                        href="/board/content?restaurantNum=${restaurant.restaurantNum}">${restaurant.menus}</a>
                                </td>
                                <td>${restaurant.category}</td>
                            </tr>
                        </c:forEach>

                    </c:if>

                </tbody>
            </table>
        </div>

        <ul class="pagination">

            <c:if test="${pageMaker.prev}">
                <li>
                    <a href="/board/list?page=${pageMaker.beginPage - 1}">[prev]</a>
                </li>
            </c:if>

            <c:forEach var="i" begin="${pageMaker.beginPage}" end="${pageMaker.endPage}" step="1">
                <li data-page="${i}"><a href="/board/list?page=${i}">[${i}]</a></li>
            </c:forEach>

            <c:if test="${pageMaker.next}">
                <li>
                    <a href="/board/list?page=${pageMaker.endPage + 1}">[next]</a>
                </li>
            </c:if>
        </ul>


        <div class="list-btn">
            <a class="btn btn-basic" href="/board/write">글쓰기</a>
        </div>
    </div>



</body>

</html>