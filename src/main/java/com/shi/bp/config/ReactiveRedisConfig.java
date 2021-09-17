package com.shi.bp.config;

import com.shi.bp.domain.SampleDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.*;

@Configuration
@PropertySource("classpath:redis.properties")
public class ReactiveRedisConfig {

	@Value("${redis.host}")
	private String redisHost;
	@Value("${redis.port}")
	private int redisPort;

	@Bean
	public LettuceConnectionFactory reactiveRedisConnectionFactory() {
		return new LettuceConnectionFactory(redisHost, redisPort);
	}

	@Bean
	public RedisSerializer<String> serializer() {
		return new StringRedisSerializer();
	}


	@Bean
	public ReactiveRedisTemplate<String, SampleDto> sampleDtoRedisTemplate(ReactiveRedisConnectionFactory connectionFactory) {
		RedisSerializer<SampleDto> sampleDtoSerializer = new GenericToStringSerializer<>(SampleDto.class);
		RedisSerializationContext<String, SampleDto> serializationContext = RedisSerializationContext
				.<String, SampleDto>newSerializationContext()
				.key(serializer()).value(sampleDtoSerializer)
				.hashKey(sampleDtoSerializer).hashValue(sampleDtoSerializer)
				.build();

		return new ReactiveRedisTemplate<>(connectionFactory, serializationContext);
	}

	@Bean
	public ReactiveRedisTemplate<String, SampleDto> sampleDtoJsonRedisTemplate(ReactiveRedisConnectionFactory connectionFactory) {
		RedisSerializer jsonSampleDtoSerializer = new Jackson2JsonRedisSerializer<>(SampleDto.class);
		RedisSerializationContext<String, SampleDto> serializationContext = RedisSerializationContext
				.<String, SampleDto>newSerializationContext()
				.key(serializer()).value(jsonSampleDtoSerializer)
				.hashKey(jsonSampleDtoSerializer).hashValue(jsonSampleDtoSerializer)
				.build();

		return new ReactiveRedisTemplate<>(connectionFactory, serializationContext);
	}

}