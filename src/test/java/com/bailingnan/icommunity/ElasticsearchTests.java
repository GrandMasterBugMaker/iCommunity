//package com.bailingnan.icommunity;
//
//import com.bailingnan.icommunity.dao.DiscussPostMapper;
//import com.bailingnan.icommunity.dao.elasticsearch.DiscussPostRepository;
//import com.bailingnan.icommunity.entity.DiscussPost;
//import org.elasticsearch.index.query.QueryBuilders;
//import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
//import org.elasticsearch.search.sort.SortBuilders;
//import org.elasticsearch.search.sort.SortOrder;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
//import org.springframework.data.elasticsearch.core.SearchHit;
//import org.springframework.data.elasticsearch.core.SearchHits;
//import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
//import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
///**
// * @author bailingnan
// * @date 2021/4/4
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@ContextConfiguration(classes = ICommunityApplication.class)
//public class ElasticsearchTests {
//
//    @Autowired
//    private DiscussPostMapper discussMapper;
//    @Autowired
//    private DiscussPostRepository discussRepository;
//
//    @Autowired
//    private DiscussPostMapper discussPostMapper;
//
//    @Autowired
//    private ElasticsearchRestTemplate elasticsearchRestTemplate; // 注意不要注入ElasticsearchTemplate
//    @Test
//    public void testInsert() {
//        discussRepository.save(discussMapper.selectDiscussPostById(241));
//        discussRepository.save(discussMapper.selectDiscussPostById(242));
//        discussRepository.save(discussMapper.selectDiscussPostById(243));
//    }
//
//    @Test
//    public void testInsertList() {
//        discussRepository.saveAll(discussMapper.selectDiscussPosts(101, 0, 100, 0));
//        discussRepository.saveAll(discussMapper.selectDiscussPosts(102, 0, 100, 0));
//        discussRepository.saveAll(discussMapper.selectDiscussPosts(103, 0, 100, 0));
//        discussRepository.saveAll(discussMapper.selectDiscussPosts(111, 0, 100, 0));
//        discussRepository.saveAll(discussMapper.selectDiscussPosts(112, 0, 100, 0));
//        discussRepository.saveAll(discussMapper.selectDiscussPosts(131, 0, 100, 0));
//        discussRepository.saveAll(discussMapper.selectDiscussPosts(132, 0, 100, 0));
//        discussRepository.saveAll(discussMapper.selectDiscussPosts(133, 0, 100, 0));
//        discussRepository.saveAll(discussMapper.selectDiscussPosts(134, 0, 100, 0));
//    }
//
//    @Test
//    public void testUpdate() {
//        DiscussPost post = discussMapper.selectDiscussPostById(231);
//        post.setContent("我是新人,使劲灌水.");
//        discussRepository.save(post);
//    }
//
//    @Test
//    public void testDelete() {
//        // discussRepository.deleteById(231);
//        discussRepository.deleteAll();
//    }
//
//    @Test
//    public void testSearchByTemplate(){
//        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
//                .withQuery(QueryBuilders.multiMatchQuery("灌水", "title", "content"))
//                .withSort(SortBuilders.fieldSort("type").order(SortOrder.DESC))
//                .withSort(SortBuilders.fieldSort("score").order(SortOrder.DESC))
//                .withSort(SortBuilders.fieldSort("createTime").order(SortOrder.DESC))
//                .withPageable(PageRequest.of(0, 10))
//                .withHighlightFields(
//                        new HighlightBuilder.Field("title").preTags("<em>").postTags("</em>"),
//                        new HighlightBuilder.Field("content").preTags("<em>").postTags("</em>")
//                ).build();
//        //elasticsearchTemplate.queryForPage()
//        //elasticsearchRestTemplate.queryForPage(searchQuery, DiscussPost.class, new SearchRe)
//
//        SearchHits<DiscussPost> search = elasticsearchRestTemplate.search(searchQuery, DiscussPost.class);
//        // 得到查询结果返回的内容
//        List<SearchHit<DiscussPost>> searchHits = search.getSearchHits();
//        // 设置一个需要返回的实体类集合
//        List<DiscussPost> discussPosts = new ArrayList<>();
//        // 遍历返回的内容进行处理
//        for(SearchHit<DiscussPost> searchHit : searchHits){
//            // 高亮的内容
//            Map<String, List<String>> highLightFields = searchHit.getHighlightFields();
//            // 将高亮的内容填充到content中
//            searchHit.getContent().setTitle(highLightFields.get("title") == null ? searchHit.getContent().getTitle() : highLightFields.get("title").get(0));
//            searchHit.getContent().setTitle(highLightFields.get("content") == null ? searchHit.getContent().getContent() : highLightFields.get("content").get(0));
//            // 放到实体类中
//            discussPosts.add(searchHit.getContent());
//        }
//        System.out.println(discussPosts.size());
//        for(DiscussPost discussPost : discussPosts){
//            System.out.println(discussPost);
//        }
//    }
//
//}
