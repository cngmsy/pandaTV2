package com.jiyun.qcloud.dashixummoban.entity.shoye;

import java.util.List;

/**
 * Created by Administrator on 2017/8/24.
 */
//滚滚视频的数据
public class GunGunBean {

    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * daytime : 2017-08-22
         * id : TITE1503474342401932
         * image : http://p1.img.cctvpic.com/photoworkspace/2017/08/22/2017082213205362928.jpg
         * order : 1
         * pid : 4f1bd9a98eb845ddbc0a4a8b27f71062
         * title : 《特别节目》看奶爸如何应对三个“熊孩子”
         * type : 2
         * url : http://live.ipanda.com/2017/08/22/VIDE93jUEzuYuJGYCsPceApF170822.shtml
         * vid :
         * videoLength : 01:03:37
         */

        private String daytime;
        private String id;
        private String image;
        private String order;
        private String pid;
        private String title;
        private String type;
        private String url;
        private String vid;
        private String videoLength;

        public String getDaytime() {
            return daytime;
        }

        public void setDaytime(String daytime) {
            this.daytime = daytime;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getVideoLength() {
            return videoLength;
        }

        public void setVideoLength(String videoLength) {
            this.videoLength = videoLength;
        }
    }
}
