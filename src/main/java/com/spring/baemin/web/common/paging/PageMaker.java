package com.spring.baemin.web.common.paging;

import lombok.Getter;
import lombok.ToString;

@Getter @ToString
public class PageMaker {

    private static final int PAGE_COUNT = 10;

    private int beginPage;
    private int endPage;
    private boolean prev, next;
    private Criteria criteria;
    private int totalCount;

    public PageMaker(Criteria criteria, int totalCount) {
        this.criteria = criteria;
        this.totalCount = totalCount;

        this.endPage = (int)Math.ceil((double)criteria.getPage() / PAGE_COUNT) * PAGE_COUNT;

        this.beginPage = endPage - PAGE_COUNT + 1;

        /*
         - 페이지 마지막 구간 끝페이지 보정
         : 총 게시물 수가 284개이고 한 화면당 10페이지씩 보여주고 있다면
           마지막 구간은 21 ~ 30이 아닌 21 ~ 29가 되어야 함.
           따라서 마지막 구간에서 endPage 보정이 필요!
          - 보정 공식: 올림값(총 게시물 수 / 한 페이지당 보여줄 게시물 수)
         */
        int realEnd = (int)Math.ceil((double)totalCount / criteria.getAmount());

        if (realEnd <= endPage) {
            this.endPage = realEnd;
        }

        this.prev = this.beginPage > 1;

        this.next = this.endPage < realEnd;
    }

}
