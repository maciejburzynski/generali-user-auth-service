package com.generali.userauthservice.user.jpaspecification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SearchCriteria {
    private String key;
    private Object value;
    private SearchOperation searchOperation;
}
