package com.boredream;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {
        String html = "\n" +
                "<!DOCTYPE html>\n" +
                "<html lang=\"zh-CN\">\n" +
                "<head>\n" +
                "    <meta name=\"renderer\" content=\"webkit\">\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"applicable-device\" content=\"pc\">\n" +
                "    <meta http-equiv=\"mobile-agent\" content=\"format=html5; url=https://m.gufengmh8.com/manhua/guanyuwozhuanshenghouchengweishilaimudenajianshi/4672.html\" /><meta http-equiv=\"mobile-agent\" content=\"format=xhtml; url=https://m.gufengmh8.com/manhua/guanyuwozhuanshenghouchengweishilaimudenajianshi/4672.html\" /><link rel=\"miphtml\" href=\"https://m.gufengmh8.com/manhua/guanyuwozhuanshenghouchengweishilaimudenajianshi/4672.html\">    <meta name=\"csrf-param\" content=\"_csrf\">\n" +
                "    <meta name=\"csrf-token\" content=\"fpN4TC9kPOGEDeHQ5aJHlP-qyHcjtyBAbJKRvBn-5AEMylU0VjF51s96kJ7S0iLZrMiELULzV3kC-vX9f5HRRA==\">\n" +
                "    <title>关于我转生后成为史莱姆的那件事第03话在线观看-古风漫画网</title>\n" +
                "    <meta name=\"keywords\" content=\"关于我转生后成为史莱姆的那件事 关于我转生后成为史莱姆的那件事第03话\">\n" +
                "<meta name=\"description\" content=\"古风漫画网为您更新关于我转生后成为史莱姆的那件事，关于我转生后成为史莱姆的那件事第03话，观看关于我转生后成为史莱姆的那件事，关于我转生后成为史莱姆的那件事第03话漫画情节，鼠标点击下一页！更多精彩漫画尽在古风漫画网！\">\n" +
                "<link href=\"/assets/dd6d4608/css/font-awesome.min.css\" rel=\"stylesheet\">\n" +
                "<link href=\"/assets/215f34d2/css/bootstrap.css\" rel=\"stylesheet\">\n" +
                "<link href=\"/plugins/toastr/toastr.min.css\" rel=\"stylesheet\">\n" +
                "<link href=\"/css/main.css\" rel=\"stylesheet\">\n" +
                "<link href=\"/assets/345369ce/css/chapter.css\" rel=\"stylesheet\">\n" +
                "<link href=\"/assets/345369ce/css/style/cadet-blue.css\" rel=\"stylesheet\">\n" +
                "<link href=\"/assets/345369ce/css/style/dark-gray.css\" rel=\"stylesheet\">\n" +
                "<link href=\"/assets/345369ce/css/style/light-green.css\" rel=\"stylesheet\">\n" +
                "<link href=\"/assets/345369ce/css/style/pink.css\" rel=\"stylesheet\">\n" +
                "<link href=\"/assets/345369ce/css/style/sea-blue.css\" rel=\"stylesheet\">\n" +
                "<script src=\"/js/phone.js\"></script>\n" +
                "<script>;phone.check(\"https://m.gufengmh8.com\");</script>    </head>\n" +
                "<body class=\"clearfix\">\n" +
                "<!--[if lte IE 8]>\n" +
                "<div class=\"ie8-warning-mask\"></div>\n" +
                "<div id=\"ie8-warning\"><p>本页面采用HTML5+CSS3，您正在使用老版本 Internet Explorer ，在本页面的显示效果可能有差异。建议您升级到 <a\n" +
                "    href=\"http://www.microsoft.com/china/windows/internet-explorer/\" target=\"_blank\">Internet Explorer 11</a> 或以下浏览器：\n" +
                "    <br>\n" +
                "    <a href=\"http://www.mozillaonline.com/\"><img src=\"https://res1.xiaoqinre.com/images/etc/browser-firefox.png\" alt=\"\"></a> /\n" +
                "    <a href=\"http://www.baidu.com/s?wd=google%E6%B5%8F%E8%A7%88%E5%99%A8\"><img src=\"https://res1.xiaoqinre.com/images/etc/browser-chrome.png\" alt=\"\"></a> /\n" +
                "    <a href=\"http://www.operachina.com/\"><img src=\"https://res1.xiaoqinre.com/images/etc/browser-opera.png\" alt=\"\"></a></p>\n" +
                "</div>\n" +
                "<![endif]-->\n" +
                "<script>;var siteName = \"\";var siteUrl = \"https://www.gufengmh8.com\";;var chapterImages = [\"1481303896WDd5T1ahM54xk_ck.jpg\",\"1481303899NVB5fbfanVVOGn62.jpg\",\"1481303901hkGmbOHQPahboBKE.jpg\",\"1481303903mBoBk2CTs4Qhd9KG.jpg\",\"1481303906IZ39w48bN3hIr_EA.jpg\",\"1481303909rocmz6gWiINmBEVj.jpg\",\"1481303911A_l-nJGlpoJlNOTk.jpg\",\"1481303914BSBps617UoE6yGE5.jpg\",\"1481303917Aax1H4lZ_OdA_Kku.jpg\",\"1481303920XcFJNuhbI8YBYr2l.jpg\",\"1481303922WKgXNHMxRw6P-K-5.jpg\",\"14813039254lDjDW4SzgjJwJj5.jpg\",\"1481303928Gmv5IUL0uabaIfKY.jpg\",\"1481303932TsO1aBZQ5vI6dZZI.jpg\",\"1481303934KHyUuUbe2Ste3s9r.jpg\",\"1481303937BJjVENtddPM9Kqey.jpg\",\"1481303940gWcy3td6GFdf2slM.jpg\",\"1481303944yXgA8jxBqE0z7Vn9.jpg\",\"14813039470Q83K10tY7-3tGHk.jpg\",\"1481303950TyWwKKuO-rgo0qV0.jpg\",\"1481303952qEhQ4e_K3v1mBsiZ.jpg\",\"1481303955PIjJdR_BfR-quaCB.jpg\",\"1481303957qmErkE72F7_iNvbE.jpg\",\"148130396012Km9jG64yc1ANgj.jpg\",\"1481303963FPrRevW1bEgqirR7.jpg\",\"1481303965F-9mIeiILokJndyI.jpg\",\"1481303967ZvigeZuoetfO9s4q.jpg\",\"1481303970hRB1i1aVudgCEsPF.jpg\",\"1481303972PxwBd0oI1-8Mdzxr.jpg\",\"1481303975UhnvZmRsofE4ZZ5j.jpg\",\"1481303977H6TG-Y_o0A6dvh8c.jpg\",\"1481303980p53iNgqa9OFUcCVZ.jpg\",\"1481303982RCcp04VCbsRZOdGY.jpg\"];var chapterPath = \"images/comic/3/4672/\";var pageTitle = \"关于我转生后成为史莱姆的那件事第03话在线观看\";var comicUrl = \"https://www.gufengmh8.com/manhua/guanyuwozhuanshenghouchengweishilaimudenajianshi/\";var pageUrl = \"https://www.gufengmh8.com/manhua/guanyuwozhuanshenghouchengweishilaimudenajianshi/\";var pageImage = \"https://res.xiaoqinre.com/images/cover/201805/1527426887jxTT2TdGzlSJw2N0.jpg\";var pageDomain = \"https://www.gufengmh8.com\";var pageId = \"comic.111\";var prevChapterData = {\"id\":4671,\"comic_id\":111,\"comic_name\":\"关于我转生后成为史莱姆的那件事\",\"status\":1,\"vip\":0,\"is_end\":0,\"name\":\"第02话\",\"type\":0,\"rtl\":0,\"image_mode\":0,\"category\":1,\"link\":\"\",\"link_name\":\"\",\"image_type\":8,\"count\":37,\"sort\":999,\"price\":0,\"created_at\":1481118060,\"updated_at\":1481303894};var nextChapterData = {\"id\":4673,\"comic_id\":111,\"comic_name\":\"关于我转生后成为史莱姆的那件事\",\"status\":1,\"vip\":0,\"is_end\":0,\"name\":\"第04话\",\"type\":0,\"rtl\":0,\"image_mode\":0,\"category\":1,\"link\":\"\",\"link_name\":\"\",\"image_type\":8,\"count\":28,\"sort\":999,\"price\":0,\"created_at\":1481118060,\"updated_at\":1481304056};</script><div class=\"chapter-view\">\n" +
                "    <div class=\"header\">\n" +
                "        <div class=\"header-inner\">\n" +
                "            <div class=\"w996 pr\" style=\"z-index: 1000;\">\n" +
                "                <div class=\"nav\">\n" +
                "                    <ul>\n" +
                "                        <li class=\"first\"><a class=\"\" href=\"/\">首页</a></li>\n" +
                "                        <li><a href=\"/list/riben/\">日本漫画</a></li>\n" +
                "                        <li><a href=\"/list/wanjie/\">经典完结</a></li>\n" +
                "                        <li><a href=\"/list/lianzai/\">热门连载</a></li>\n" +
                "                        <li><a href=\"/update/\">最新更新</a></li>\n" +
                "                        <li><a href=\"/comic/rank/\">热门排行</a></li>\n" +
                "                        <li id=\"history\" class=\"last\"><a href=\"javascript:;\">观看历史记录</a><i></i>\n" +
                "                            <div id=\"hListBox\" class=\"hlist-box\">\n" +
                "                                <div class=\"hlist\" id=\"hList\"></div>\n" +
                "                                <div class=\"hlist-remove\"><a id=\"hListClear\"\n" +
                "                                                             href=\"javascript:SinMH.clearHistory();\">清空全部记录</a></div>\n" +
                "                            </div>\n" +
                "                        </li>\n" +
                "                    </ul>\n" +
                "                </div>\n" +
                "\n" +
                "                <div class=\"search pa\">\n" +
                "                    <input placeholder=\"请输入关键字...\" id=\"keywords\" value=\"\" autocomplete=\"off\"/>\n" +
                "                    <button id=\"btnSearch\">搜索</button>\n" +
                "                    <div id=\"search-results\" class=\"suggest\"></div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "    <div class=\"w996 title pr\">\n" +
                "        <div class=\"nav-skin\" id=\"skin\"> 阅读背景\n" +
                "            <ul>\n" +
                "                <li class=\"skin0\"><a href=\"javascript:SinTheme.switchStyle(0);\" title=\"白色\">白色</a></li>\n" +
                "                <li class=\"skin1\"><a href=\"javascript:SinTheme.switchStyle(1);\" title=\"深灰\">深灰</a></li>\n" +
                "                <li class=\"skin2\"><a href=\"javascript:SinTheme.switchStyle(2);\" title=\"粉红\">粉红</a></li>\n" +
                "                <li class=\"skin3\"><a href=\"javascript:SinTheme.switchStyle(3);\" title=\"灰蓝\">灰蓝</a></li>\n" +
                "                <li class=\"skin4\"><a href=\"javascript:SinTheme.switchStyle(4);\" title=\"淡绿\">淡绿</a></li>\n" +
                "                <li class=\"skin5\"><a href=\"javascript:SinTheme.switchStyle(5);\" title=\"海蓝\">海蓝</a></li>\n" +
                "            </ul>\n" +
                "        </div>\n" +
                "        <h1><a href=\"/manhua/guanyuwozhuanshenghouchengweishilaimudenajianshi/\">关于我转生后成为史莱姆的那件事</a></h1>\n" +
                "        <em>/</em>\n" +
                "        <h2>第03话</h2>\n" +
                "        <em>/</em>\n" +
                "        <span>(<span id=\"page\" class=\"curPage\"></span>33)</span>\n" +
                "    </div>\n" +
                "\t<div class=\"w996\" align=\"center\"><script src=\"https://www.gufengmh8.com/gufeng-gg/youcegg-xq.js\"></script></div>\n" +
                "    <div class=\"w996 tc\" style=\"margin: 6px auto;\">\n" +
                "        <div class=\"main-btn\">\n" +
                "            <a href=\"/manhua/guanyuwozhuanshenghouchengweishilaimudenajianshi/\">返回目录(<span class=\"back\"></span>)</a>            <a href=\"javascript:SinTheme.prevChapter();\" class=\"prevC\">上一章(<span class=\"prevChapter\"></span>)</a>\n" +
                "            <a href=\"javascript:SinTheme.prevPage();\" class=\"nav-pagination\">上一页(<span class=\"prevPage\"></span>)</a>\n" +
                "            <select class=\"pageSelect nav-pagination\"\n" +
                "                    onchange=\"SinTheme.jumpPage(this.options[this.selectedIndex].value);\"></select>\n" +
                "            <a href=\"javascript:SinTheme.nextPage();\" class=\"nav-pagination\">下一页(<span class=\"nextPage\"></span>)</a>\n" +
                "            <a href=\"javascript:SinTheme.nextChapter();\" class=\"nextC\">下一章(<span class=\"nextChapter\"></span>)</a>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "\t<div class=\"w996\" align=\"center\"><script src=\"https://www.gufengmh8.com/gufeng-gg/youcegg-xq2.js\"></script></div>\n" +
                "    <div class=\"w996 cf nav-sub\" id=\"subNav\">\n" +
                "        <div class=\"action\">\n" +
                "            <ul>\n" +
                "                <li class=\"share\">\n" +
                "                    <div class=\"bdsharebuttonbox\"><a href=\"#\" class=\"bds_more\" data-cmd=\"more\"></a><a href=\"#\" class=\"bds_qzone\" data-cmd=\"qzone\" title=\"分享到QQ空间\"></a><a href=\"#\" class=\"bds_tsina\" data-cmd=\"tsina\" title=\"分享到新浪微博\"></a><a href=\"#\" class=\"bds_weixin\" data-cmd=\"weixin\" title=\"分享到微信\"></a><a href=\"#\" class=\"bds_sqq\" data-cmd=\"sqq\" title=\"分享到QQ好友\"></a><a href=\"#\" class=\"bds_tieba\" data-cmd=\"tieba\" title=\"分享到百度贴吧\"></a><a href=\"#\" class=\"bds_bdhome\" data-cmd=\"bdhome\" title=\"分享到百度新首页\"></a></div>\n" +
                "<script>window._bd_share_config={\"common\":{\"bdSnsKey\":{},\"bdText\":\"\",\"bdMini\":\"2\",\"bdMiniList\":false,\"bdPic\":\"\",\"bdStyle\":\"0\",\"bdSize\":\"24\"},\"share\":{}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>                </li>\n" +
                "            </ul>\n" +
                "        </div>\n" +
                "        <div class=\"server pull-right\"><span>阅读方式→ &nbsp;</span>\n" +
                "            <a href=\"javascript:SinTheme.setChapterScroll(false);\" id=\"chapter-pagination\">分页阅读</a><em>|</em>\n" +
                "            <a href=\"javascript:SinTheme.setChapterScroll(true);\" id=\"chapter-scroll\">下拉阅读</a>\n" +
                "        </div>\n" +
                "        <div class=\"server pull-right\" id=\"res-server\"> 线路选择→ &nbsp;\n" +
                "            <a id=\"host-auto\" data-host=\"auto\" href=\"javascript:;\">自动</a><em>|</em>\n" +
                "            <a id=\"host-telecom\" data-host=\"telecom\" href=\"javascript:;\">电信</a><em>|</em>\n" +
                "            <a id=\"host-unicom\" data-host=\"unicom\" href=\"javascript:;\">联通</a>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "    <div id=\"tbCenter\" class=\"pr tbCenter clearfix\">\n" +
                "                    <div id=\"images\">\n" +
                "                <div class=\"main-left\" id=\"sider-left\" style=\"display:block;\"><!--广告位--></div>\n" +
                "                <div class=\"main-right\" id=\"sider-right\" style=\"display:block;\"><!--广告位--></div>\n" +
                "            </div>\n" +
                "            <div class=\"img-loading\" id=\"imgLoading\"><i></i><span>图片努力加载中，请稍候</span></div>\n" +
                "            </div>\n" +
                "\t<div class=\"w996\" align=\"center\"><script src=\"https://www.gufengmh8.com/gufeng-gg/youcegg-xq3.js\"></script></div>\n" +
                "    <div class=\"w996 tc\" style=\"margin: 6px auto;\">\n" +
                "        <div class=\"main-btn\">\n" +
                "            <a href=\"/manhua/guanyuwozhuanshenghouchengweishilaimudenajianshi/\">返回目录(<span class=\"back\"></span>)</a>            <a href=\"javascript:SinTheme.prevChapter();\" class=\"prevC\">上一章(<span class=\"prevChapter\"></span>)</a>\n" +
                "            <a href=\"javascript:SinTheme.prevPage();\" class=\"nav-pagination\">上一页(<span class=\"prevPage\"></span>)</a>\n" +
                "            <select class=\"pageSelect nav-pagination\"\n" +
                "                    onchange=\"SinTheme.jumpPage(this.options[this.selectedIndex].value);\"></select>\n" +
                "            <a href=\"javascript:SinTheme.nextPage();\" class=\"nav-pagination\">下一页(<span class=\"nextPage\"></span>)</a>\n" +
                "            <a href=\"javascript:SinTheme.nextChapter();\" class=\"nextC\">下一章(<span class=\"nextChapter\"></span>)</a>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "\t<div class=\"w996\" align=\"center\"><script src=\"https://www.gufengmh8.com/gufeng-gg/youcegg-xq4.js\"></script></div>\n" +
                "    </br>\n" +
                "    <div class=\"w996 comic-comment\">\n" +
                "            </div>\n" +
                "</div>\n" +
                "<div class=\"footer\">\n" +
                "    <div class=\"footer-main\">\n" +
                "        <div class=\"w996 tc\">本页面为您提供关于我转生后成为史莱姆的那件事 - 第03话漫画在线阅读,关于我转生后成为史莱姆的那件事漫画的版权归原漫画作者及发行商所有。\n" +
                "            \t<p>古风漫画网为非赢利性站点,本网站所有漫画资源均收集于互联网,只提供web页面服务;如有发现侵犯您的权益,请告诉我们,我们会在核实无误后删除相关内容. </p>\n" +
                "                <p> Copyright © 2016 <em>/</em> GuFengMH8.Com <em>/</em> All Rights Reserved <em>/</em> <a href=\"/\">古风漫画网</a> <em>/</em> 版权所有<em>/</em> 蜀ICP备16035243号-1 </p> \n" +
                "        </div>\n" +
                "\n" +
                "    </div>\n" +
                "</div>\n" +
                "<div class=\"t_j\" style=\"display: none\"><script src=\"https://www.gufengmh8.com/assets/t_j/tongji.js\"></script></div>\n" +
                "<div class=\"scroll-top\"><a href=\"javascript:SinMH.scrollTo(0);\" id=\"backTop\" title=\"返回顶部\">回到顶部</a></div>\n" +
                "<!-- }版权结束-->\n" +
                "<script id=\"res-template\" type=\"text/html\">\n" +
                "    <span>线路选择→ &nbsp;</span>\n" +
                "    <%if(list&&list.length>0){\n" +
                "    var resHostIndex = SinMH.getResHostIndex();\n" +
                "    for(var i = 0; i\n" +
                "    <list.length;i++){\n" +
                "    var item = list[i];\n" +
                "    var active = i == resHostIndex?'active':'';\n" +
                "    %>\n" +
                "    <a href=\"javascript:SinMH.setResHost(<%=i%>)\" class=\"<%=active %>\"><%=item.name%></a>\n" +
                "    <%}\n" +
                "    }else{%>\n" +
                "    无服务器可选\n" +
                "    <%}%>\n" +
                "</script>\n" +
                "<script id=\"search-template\" type=\"text/html\">\n" +
                "    <%if(items&&items.length>0){%>\n" +
                "    <%for(var i = 0; i\n" +
                "    <items.length;i++){\n" +
                "    var item = items[i];\n" +
                "    %>\n" +
                "    <li title=\"<%=item.title%>\" data-url=\"<%= item.uri %>\">\n" +
                "        <span class=\"pull-right\">更新至：\n" +
                "        <a href=\"<%= item.uri+ item.last_chapter_id%>.html\"><%=item.last_chapter_name%></a></span>\n" +
                "        [<a href=\"/author/id-<%= item.author_id %>/\"><%=item.author%></a>]\n" +
                "        <a href=\"<%= item.uri %>\"><%=item.title%></a>\n" +
                "        [<span class=\"<%=item.serialise==1?'text-danger':'text-success'%>\"><%=item.serialise==1?'连载中':'已完结'%></span>]\n" +
                "\n" +
                "    </li>\n" +
                "    <%}%>\n" +
                "    <%}else{%>\n" +
                "    暂无搜索结果\n" +
                "    <%}%>\n" +
                "</script>\n" +
                "<script id=\"history-template\" type=\"text/html\">\n" +
                "    <%if(list&&list.length>0){%>\n" +
                "    <ul>\n" +
                "        <%for(var i = 0; i < list.length;i++){\n" +
                "        var item = list[i];\n" +
                "        %>\n" +
                "        <li>\n" +
                "            <a class=\"hdel fr\" title=\"删除\" rel=\"<%=item.comic_id%>\"\n" +
                "               href=\"javascript:SinMH.removeHistory(<%=item.comic_id%>)\"><span>删除</span></a>\n" +
                "            <a class=\"book\" href=\"<%=item.comic_url%>\"><%=item.comic_name%></a> <em>[</em>\n" +
                "            <a href=\"<%=item.read_chapter_url%>\" class=\"red\"><%=item.read_chapter%></a> <em>]</em>\n" +
                "            <div>\n" +
                "                <span class=\"fr\"><a href=\"<%=item.read_chapter_url%>#p=<%=item.read_page%>\">继续观看</a></span>\n" +
                "                <span class=\"htime\">上次于 <%= filter.asDateTime(item.read_at)%> 观看</span>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <%}%>\n" +
                "    </ul>\n" +
                "    <%}else{%>\n" +
                "    暂无历史纪录\n" +
                "    <%}%>\n" +
                "</script>\n" +
                "\n" +
                "<script src=\"/assets/b3084444/jquery.js\"></script>\n" +
                "<script src=\"/assets/adf75bb4/yii.js\"></script>\n" +
                "<script src=\"/assets/215f34d2/js/bootstrap.js\"></script>\n" +
                "<script src=\"/plugins/toastr/toastr.min.js\"></script>\n" +
                "<script src=\"/plugins/baiduTemplate.js\"></script>\n" +
                "<script src=\"/plugins/jquery/jquery.cookie.js\"></script>\n" +
                "<script src=\"/plugins/jquery/jquery.image.js\"></script>\n" +
                "<script src=\"/plugins/jquery/jquery.lazyload.min.js\"></script>\n" +
                "<script src=\"/plugins/jquery/jquery.hotkeys.js\"></script>\n" +
                "<script src=\"/plugins/bootstrap/bootstrap.hover.dropdown.js\"></script>\n" +
                "<script src=\"/plugins/bootstrap/bootstrap.hover.tab.js\"></script>\n" +
                "<script src=\"/js/config.js\"></script>\n" +
                "<script src=\"/js/common.js\"></script>\n" +
                "<script src=\"/assets/345369ce/js/theme.js\"></script>\n" +
                "<script>jQuery(function ($) {\n" +
                ";SinMH.init();SinTheme.init();$(\"img\").lazyload();SinMH.initChapter(4672,\"第03话\",111,\"关于我转生后成为史莱姆的那件事\");\n" +
                "SinTheme.initChapter(4672,\"第03话\",111,\"关于我转生后成为史莱姆的那件事\");\n" +
                "});</script></body>\n" +
                "</html>\n" +
                "\n";

        Pattern compile = Pattern.compile("var chapterPath = \"(.*?)\";");
        Matcher matcher = compile.matcher(html);
        if(matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }

}
