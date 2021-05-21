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
                        <th width="10%">매점번호</th>
                        <th>매점명</th>
                        <th width="15%">연락처</th>
                        <th>메뉴</th>
                        <th width="15%">카테고리</th>
                    </tr>

                    <%-- 게시물 개수가 0개일 경우 목록대신 "게시물이 존재하지 않습니다." 출력 --%>
                    <c:if test="${list.size() <= 0}">
                        <tr>
                            <td class="no-article" colspan="5">게시물이 존재하지 않습니다.</td>
                        </tr>
                    </c:if>

                    <c:if test="${list.size() > 0}">
                        <%-- 컨트롤러가 가져온 게시글 데이터를 반복하여 출력. --%>
                        <c:forEach var="restaurant" items="${list}">
                            <tr data-num="${restaurant.restaurantNum}">
                                <td>${restaurant.restaurantNum}</td>
                                <td>${restaurant.restaurantName}</td>
                                <td>${restaurant.number}</td>
                                <td><a
                                        href="/board/content?restaurantNum=${restaurant.restaurantNum}">${restaurant.menus}</a>
                                </td>
                                <td>${restaurant.category.foodName}</td>
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


    <script>
        document.querySelector('table.table').addEventListener('click', e => {

            if (!e.target.matches('table.table tr td')) return;

            console.log('tr clicked!', e.target);
            location.href = '/board/content?restaurantNum=' + e.target.parentNode.dataset.num;
        });
    </script>



</body>

</html>