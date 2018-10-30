package com.android.dcxiaolou.bmobdata.mode;

import java.util.List;

/*
* 对阅读模块下的文章返回的json文件进行处理，便于使用Gson进行解析
* */

public class ReadArticleResult {


    /**
     * image : http://ossimg.xinli001.com/visioncn/600x400/VCG41175305570.jpg!180x120
     * article_url : https://www.xinli001.com/info/100011394
     * title : 高情商者的15个表现
     * attr : Little Mellon
     * view : 1290332
     * digg : 448
     * tag : ["社会心理学","进化心理学"]
     * article_class : 心理科普
     * push_time : ["发表于2016-03-17 19:15:00"]
     * article_detail : ["\n\t\t\t\t<div class=\"yxl-editor-article is-old-article\">\n\t\t\t\t\t\t\t\t\t\t<h6><span style=\"\">译：Little Mellon|壹心理翻译专栏<\/span><br/><\/h6><h6><span style=\"\"><br/><\/span><\/h6><p><strong style=\"color: rgb(0, 0, 0);\">1. 你喜欢钻研他人行事的动机。<\/strong><\/p><p>情商高的人对人类行为非常着迷。他们会注意到其他人的肢体语言、方言甚至是脸部微妙的抽搐。因为他们喜欢观察别人，所以也就能明白每个人的独特之处。<\/p><p><strong style=\"color: rgb(0, 0, 0);\">2. 你是热情的领导者，言出必行。<\/strong><\/p><p>情商高的人都知道要言出必行。作为领导者，他们不是站在背后发号施令，而是走在前面做出表率。<\/p><p><strong style=\"color: rgb(0, 0, 0);\">3. 你清楚自己的优势和短板。<\/strong><\/p><p>情商高的人知道，最大的缺陷不能说明你弱势的一面，而最大的优势则可以显示出你强势的一面。他们会充分发挥自己最大的优势，来弥补自身不足。<\/p><p><strong style=\"color: rgb(0, 0, 0);\">4. 你能够平静地面对过去。<\/strong><\/p><p>情商高的人根本没有时间去后悔。他们放下过去，着眼当前。因为他们知道，只有这样才能进步。<\/p><p><strong style=\"color: rgb(0, 0, 0);\">5. 你对未来充满信心。<\/strong><\/p><p>情商高的人并不会因为未来难以预料而心神不宁。他们的生活很快乐，不需要水晶球预测未来。因为对他们来说，生命应当是一次刺激的冒险之旅，而非预先安排的常规生活。<\/p><p><strong style=\"color: rgb(0, 0, 0);\">6. 你能够活在当下，体会当前的每一刻。<\/strong><\/p><p>情商高的人不会简单地\u201c度过\u201d每一天。相反，他们会积极体验每一天每一刻的细腻与微妙。<\/p><p><strong style=\"color: rgb(0, 0, 0);\">7. 你是一个成熟主动的聆听者。<\/strong><\/p><p>情商高的人知道，\u201c听到\u201d和\u201c聆听\u201d是两个截然不同的概念。他们会用提问题的形式重复别人说过的话，确保自己没有遗漏任何信息。<\/p><p><strong style=\"color: rgb(0, 0, 0);\">8. 你知道自己为什么不高兴。<\/strong><\/p><p>情商高的人不会让自己的消极情绪影响自己。他们会主动寻找自己不开心的原因，最重要的是，他们会想办法让自己开心起来。<\/p><p><strong style=\"color: rgb(0, 0, 0);\">9. 你能自如地和朋友以及陌生人交谈。<\/strong><\/p><p>情商高的人从不会不喜欢陌生人。他们不在乎陌生人的年龄、种族、宗教、性别、性取向或者政治立场。因为他们知道，我们都是一样的人，所以对待每个人都一样。<\/p><p><strong style=\"color: rgb(0, 0, 0);\">10. 你在生活和工作上都严守道德标准。<\/strong><\/p><p>无论是在工作还是生活上，情商高的人都会遵循道德标准和原则。他们每一个人的价值观可能会有所不同，但是都会用高标准来要求自己。<\/p><p><strong style=\"color: rgb(0, 0, 0);\">11. 你非常热心助人。<\/strong><\/p><p>情商高的人认为助人不需要理由。他们会帮老太太拎食品袋，会在晚餐后帮朋友或另一半洗碗；如果他先进门，无论后面是女士还是男士，他都会为他们把住门。<\/p><p><strong style=\"color: rgb(0, 0, 0);\">12. 你能像读一本书一样去了解一个人。<\/strong><\/p><p>情商高的人会关注一个人的手势、表情和肢体语言。他们知道不能仅仅依靠一个人的言语来认识他，因为一个人说的话通常不能变现为他的全部。<\/p><p><strong style=\"color: rgb(0, 0, 0);\">13. 你坚定地追求自己的目标。<\/strong><\/p><p>不论要花费多长的时间，情商高的人都会为成功不断努力。他们愿意面对问题，解决问题。因为，只要不放弃，成功终会如约而至。<\/p><p><strong style=\"color: rgb(0, 0, 0);\">14. 你拥有强大的内心驱动力。<\/strong><\/p><p>情商高的人有长久的内心推动力。他们不去想最后的结果究竟如何，而是享受整个过程。因为，个人的成长并不是源于成功的那一刻，而是源于为成功奋斗的整个过程。<\/p><p><strong style=\"color: rgb(0, 0, 0);\">15. 你在必要的时候敢于说不。<\/strong><\/p><p>情商高的人知道即使是面对好东西，也要把握适度的原则。他们知道自己不可能做到所有事情，所以会优先处理最重要的事。<\/p><p style=\"text-align: center;\">\u2014THE END\u2014<\/p><p><br/><\/p><h6>作者：DANIEL WALLEN<\/h6><h6>原文：15 Signs That You Are Emotionally Intelligent<\/h6><h6>来源：lifehack.org<\/h6><h6><br/><\/h6><hr/><p><br/><\/p><p>一个情商高的人，不仅能让身边的人感到相处很舒服，也能让自己的情绪得到合理释放。你是一个高情商的人吗？<\/p><p><span style=\"\"><br/><\/span><\/p><p><span style=\"\">↓点击链接测试一下吧↓<\/span><\/p><p><strong><span style=\"\"><span style=\"\"><a href=\"http://m.xinli001.com/proceshi/99897522\" target=\"_blank\" style=\"\">情商测试（专业版）：测测你的情商有多高？<\/a><\/span><\/span><\/strong><\/p><p><span style=\"\">沟通是一门艺术，所谓的高情商，归根到底，其实不过是在人际交往过程中，懂得沟通。<\/span><\/p><p><br/><\/p><ul class=\" list-paddingleft-2\" style=\"list-style-type: disc;\"><li><p><span style=\"\">怎么样说话才是高情商的沟通方式？<\/span><\/p><\/li><li><p><span style=\"\">怎样跟任何人都聊得来，成为受欢迎的人？<\/span><\/p><\/li><li><p><span style=\"\">如何迅速获得别人的信任？<\/span><\/p><\/li><li><p><span style=\"\">如何游刃有余地与别人建立好的关系？<\/span><\/p><\/li><\/ul><p><br/><\/p><p><span style=\"\">向你推荐<\/span>武志红力荐的课程\u2014\u2014\u201c最懂关系的心理学家\u201d胡慎之老师的<strong>《人际交往中，如何成为一个高情商的人》<\/strong>，它将手把手教你掌握高情商沟通术。<\/p><p><a href=\"https://m.xinli001.com/lesson/145?channel_id=wzwenmoztgqs0509\" target=\"_blank\" title=\"人际交往中，如何成为一个高情商的人\"><img src=\"http://ossimg.xinli001.com/visioncn/600x400/VCG41108161774.jpg\n\"/><\/a><\/p><p><br/><\/p><p><br/><\/p><p><br/><img alt=\"undefined\" src=\"http://ossimg.xinli001.com/visioncn/600x400/VCG41592007619.jpg\n\"/><br/><\/p><p><br/><\/p>\t\t\t\t"]
     */

    private String image;
    private String article_url;
    private String title;
    private String attr;
    private String view;
    private String digg;
    private String article_class;
    private List<String> tag;
    private List<String> push_time;
    private List<String> article_detail;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getArticle_url() {
        return article_url;
    }

    public void setArticle_url(String article_url) {
        this.article_url = article_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getDigg() {
        return digg;
    }

    public void setDigg(String digg) {
        this.digg = digg;
    }

    public String getArticle_class() {
        return article_class;
    }

    public void setArticle_class(String article_class) {
        this.article_class = article_class;
    }

    public List<String> getTag() {
        return tag;
    }

    public void setTag(List<String> tag) {
        this.tag = tag;
    }

    public List<String> getPush_time() {
        return push_time;
    }

    public void setPush_time(List<String> push_time) {
        this.push_time = push_time;
    }

    public List<String> getArticle_detail() {
        return article_detail;
    }

    public void setArticle_detail(List<String> article_detail) {
        this.article_detail = article_detail;
    }
}
