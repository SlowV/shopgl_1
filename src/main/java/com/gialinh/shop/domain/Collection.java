package com.gialinh.shop.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author SlowV ❤ H3yae
 * @createdAt 2/5/21_1:06 PM
 * @updatedAt 2/5/21_1:06 PM
 *
 * Class entity Collection {@link com.gialinh.shop.domain.Collection}
 */
@Entity
@Table(name = "collections")
public class Collection extends AbstractAuditingEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "url_image", nullable = false)
    private String urlImage;
}
