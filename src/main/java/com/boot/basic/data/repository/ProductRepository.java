package com.boot.basic.data.repository;

import com.boot.basic.data.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JpaRepository 타입의 첫번째 인자는 JpaRepository가 사용할 repo 지정
 * 두번째 인자는 repo 에서 사용되는 id 타입을 지정
 * @Repository 어노테이션 생략 가능
 * */
public interface ProductRepository extends JpaRepository<ProductEntity, String> {
}
