package Utilities.Visitor;

/**
 * Created by dyeung on 4/16/16.
 */
public interface ItemVisitable {
    void acceptItemVisitor(ItemVisitor itemVisitor);
}
