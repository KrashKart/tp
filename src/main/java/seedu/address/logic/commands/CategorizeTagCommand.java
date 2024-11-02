package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.tag.Tag;
import seedu.address.model.tag.TagCategory;


/**
 * Implements command to categorize all occurrences of a tag.
 * Format: cattag t/TAG CATEGORY
 */
public class CategorizeTagCommand extends Command {

    public static final String COMMAND_WORD = "cattag";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Categorizes a tag. Changes all occurrences of the specified tag to the desired category.\n"
            + "Parameters: " + PREFIX_TAG + "TAG (existing tag label) CATEGORY\n"
            + "Example: " + COMMAND_WORD + " " + PREFIX_TAG + "CS1101S module";

    public static final String MESSAGE_CAT_TAG_SUCCESS = "Category of tag %1$s has been changed successfully.";
    public static final String MESSAGE_TAG_NOT_EXIST = "Tag not found: %1$s";
    public static final String MESSAGE_INVALID_CATEGORY = "Invalid category: %1$s";

    private final Tag targetTag;
    private final TagCategory updatedCategory;

    /**
     * Constructs a command to categorize a tag.
     */
    public CategorizeTagCommand(Tag targetTag, TagCategory updatedCategory) {
        requireNonNull(targetTag);
        requireNonNull(updatedCategory);
        this.targetTag = targetTag;
        this.updatedCategory = updatedCategory;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        assert model != null;
        if (!model.containsTag(targetTag)) {
            throw new CommandException(String.format(MESSAGE_TAG_NOT_EXIST, targetTag));
        }
        model.setTagsCategory(targetTag, updatedCategory);
        return new CommandResult(String.format(MESSAGE_CAT_TAG_SUCCESS, targetTag));
    }
}