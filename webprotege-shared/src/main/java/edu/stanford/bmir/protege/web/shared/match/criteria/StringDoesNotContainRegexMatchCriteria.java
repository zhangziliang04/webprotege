package edu.stanford.bmir.protege.web.shared.match.criteria;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.auto.value.AutoValue;
import com.google.common.annotations.GwtCompatible;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 17 Jun 2018
 */
@AutoValue
@GwtCompatible(serializable = true)
@JsonTypeName("StringDoesNotContainRegexMatch")
public abstract class StringDoesNotContainRegexMatchCriteria implements LexicalValueCriteria {

    @Nonnull
    public abstract String getPattern();

    public abstract boolean ignoreCase();

    @JsonCreator
    @Nonnull
    public static StringDoesNotContainRegexMatchCriteria get(@Nonnull String pattern,
                                                             boolean ignoreCase) {
        return new AutoValue_StringDoesNotContainRegexMatchCriteria(pattern, ignoreCase);
    }

    @Override
    public <R> R accept(@Nonnull LexicalValueCriteriaVisitor<R> visitor) {
        return visitor.visit(this);
    }

}
