<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>신규 매점 등록</title>
    <link rel="stylesheet" href="/css/main.css"/>
</head>

<body>

    <div class="wrap">
        <h1>신규 매점 등록</h1>

        <div class="table-box">
            <form action="/board/write" method="POST">
                <table class="table write-table">
                    <tbody>
                        <tr>
                            <th width="15%"><label for="restaurantName"># 매점명:</label></th>
                            <td><input type="text" name="restaurantName"></td>
                            <th width="15%"><label for="number"># 연락처:</label></th>
                            <td><input type="text" name="number"></td>
                            <th width="15%"><label for="category"># 카테고리:</label></th>
                            <td>
                                <select class="select-box" name="category">
                                    <option value="">--카테고리 선택--</option>
                                    <option value="KOREAN_FOOD">한식</option>
                                    <option value="CHINA_FOOD">중식</option>
                                    <option value="ITALY_FOOD">이태리식</option>
                                    <option value="JAPAN_FOOD">일식</option>
                                </select>
                            </td>
                        </tr>

                        <tr>
                        	<th colspan="6"><label for="menus"># 메뉴</label></th>
                        </tr>
                        <tr>
                        	<td colspan="6"><textarea name="menus" cols="30" rows="15"></textarea></td>
                        </tr>
                    </tbody>
                </table>

                <div class="list-btn">
                    <button type="submit" class="btn btn-basic">새글 등록</button>
                    <a class="btn btn-basic" href="/board/list">목록 보기</a>
                </div>
            </form>
        </div>

    </div>


</body>

</html>