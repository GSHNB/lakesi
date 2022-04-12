package com.nsxz.lakesi.model.mapper

import com.nsxz.lakesi.db.ArticleEntity
import com.nsxz.lakesi.model.Article

class Entity2ItemModelMapper:Mapper<ArticleEntity,Article> {
    override fun map(input: ArticleEntity): Article {
        return Article(
            id = input.id,
            title = input.title,
            author = input.author
        )
    }
}