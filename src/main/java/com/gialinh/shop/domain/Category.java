package com.gialinh.shop.domain;


import javax.persistence.*;
import java.io.Serializable;

/**
 * @author SlowV ❤ H3yae
 * @createdAt 2/5/21_11:38 AM
 * @updatedAt 2/5/21_11:38 AM
 *
 * Class entity Category {@link com.gialinh.shop.domain.Category}
 */
@Entity
@Table(name = "categories")
public class Category extends AbstractAuditingEntity implements Serializable {
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

    @ManyToOne
    private Category parent;
}
