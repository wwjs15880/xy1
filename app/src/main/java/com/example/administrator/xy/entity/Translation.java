package com.example.administrator.xy.entity;

import java.util.List;

public class Translation {

    public int errCode;
    public ResultBean result;

    public class ResultBean {
        public ArticleListBean articleList;
        public List<HotArticleBean> hotArticle;
        public List<?> hotArticle2;

        public class ArticleListBean {
            public int total;
            public List<RowsBean> rows;

            public class RowsBean {
                public String iArticleID;
                public String iProductID;
                public String szTitle;
                public int iReadCnt;
                public int iCommentCnt;
                public int iHotType;
                public int iAttacheFlag;
                public String dtTime;
                public String szSummary;
                public String iQQ;
                public AuthorBean author;

                public class AuthorBean {
                    public String iQQ;
                    public BaseInfoBean baseInfo;

                    public class BaseInfoBean {
                        public String szNickName;
                        public String szHeaderUrl;
                        public int iWeekActive;
                        public List<NewProfileBean> newProfile;

                        public class NewProfileBean {
                            public int iProductID;
                            public String szProfileDesc;
                        }
                    }
                }
            }
        }

        public class HotArticleBean {
            public String iArticleID;
            public String iProductID;
            public String szTitle;
        }
    }
}
