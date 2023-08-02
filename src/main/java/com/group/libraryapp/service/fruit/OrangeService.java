package com.group.libraryapp.service.fruit;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary // Qualifier보다 우선순위 낮음
public class OrangeService implements FruitService{
}
