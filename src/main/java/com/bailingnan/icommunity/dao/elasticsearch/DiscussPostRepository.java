package com.bailingnan.icommunity.dao.elasticsearch;

import com.bailingnan.icommunity.entity.DiscussPost;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author bailingnan
 * @date 2021/4/4
 */
@Repository
public interface DiscussPostRepository extends ElasticsearchRepository<DiscussPost, Integer> {

}