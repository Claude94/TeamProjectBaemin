<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>매점 정보 상세보기</title>
    <link rel="stylesheet" href="/css/main.css"/>
</head>

<body>

    <div class="wrap">
        <h1>No.${restaurant.restaurantNum} 매점 정보 상세보기</h1>

        <div class="table-box">


            <table class="table view-table">
                <tbody>
                    <tr>
                        <th width="15%"># 매점명:</th>
                        <td>${restaurant.restaurantName}</td>
                        <th width="15%"># 연락처:</th>
                        <td>${restaurant.number}</td>
                        <th width="15%"># 카테고리:</th>
                        <td>${restaurant.category.foodName}</td>
                    </tr>

                    <tr>
                        <th colspan="6"># 메뉴</th>
                    </tr>
                    <tr>
                        <td colspan="6">
                            <textarea class="content-box" name="menus" cols="30" rows="15" disabled>${restaurant.menus}</textarea>
                        </td>
                    </tr>
                </tbody>
            </table>

            <div class="list-btn">
                <a class="btn btn-basic" href="/board/modify?restaurantNum=${restaurant.restaurantNum}">글수정</a>
                <a class="btn btn-basic" href="/board/delete?restaurantNum=${restaurant.restaurantNum}">삭제</a>
                <a class="btn btn-basic" href="/board/list">목록 보기</a>
            </div>
        </div>

    </div>

</body>

</html>