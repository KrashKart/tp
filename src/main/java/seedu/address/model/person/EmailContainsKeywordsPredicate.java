package seedu.address.model.person;

import java.util.List;

import seedu.address.commons.util.ToStringBuilder;

/**
 * Tests that a {@code Person}'s {@code Name} matches any of the keywords given.
 */
public class EmailContainsKeywordsPredicate extends ContainsKeywordsPredicate {

    public EmailContainsKeywordsPredicate(List<String> keywords) {
        super(keywords);
    }

    @Override
    public boolean test(Person person) {
        return super.getKeywords().stream()
                .anyMatch(keyword -> person.getEmail().value.toLowerCase().contains(keyword.toLowerCase()));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof EmailContainsKeywordsPredicate)) {
            return false;
        }

        EmailContainsKeywordsPredicate otherNameContainsKeywordsPredicate = (EmailContainsKeywordsPredicate) other;
        return this.getKeywords().equals(otherNameContainsKeywordsPredicate.getKeywords());
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("keywords", this.getKeywords()).toString();
    }
}
