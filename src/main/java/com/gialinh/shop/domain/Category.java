package com.gialinh.shop.domain;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

/**
 * @author SlowV ❤ H3yae
 * @createdAt 2/5/21_11:38 AM
 * @updatedAt 2/5/21_11:38 AM
 *
 * Class entity Category {@link com.gialinh.shop.domain.Category}
 */
@Getter
@Setter
@Entity
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "categories")
public class Category extends AbstractAuditingEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Lob
    @Column(name = "description")
    @Type(type = "org.hibernate.type.TextType")
    private String description;

    @Column(name = "url_image", nullable = false)
    private String urlImage;

    @ManyToOne
    private Category parent;

    public Category created_by(String name) {
        super.createdBy = name;
        return this;
    }

    public Instant getCreatedDate() {
        return super.createdDate;
    }
}
