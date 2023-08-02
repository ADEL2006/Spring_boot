package com.group.libraryapp.service.fruit;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("main") // 직접 특별히 지정하는것은 우선순위가 높다.
public class BananaService implements FruitService{
}
