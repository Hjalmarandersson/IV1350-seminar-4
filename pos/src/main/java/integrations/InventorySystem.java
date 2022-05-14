
package integrations;

import integrations.Item;

/**
 * Represents the store's inventory system which keeps all items in store.
 * @author Hjalmar
 */
public class InventorySystem {
    
    private Item inventory[] = {
            new Item(0,"1kg Potatoe","Swedish potatoes", 15.5, 0.06),
            new Item(1,"500g Meatballs","Swedish Meatballs", 45.5, 0.06),
            new Item(2,"250g Lingonberry jam","Swedish Lingonberry jam", 35, 0.06),
            new Item(3,"Brown sauce","Swedish Brown sauce", 20, 0.06)
        };
    
    /**
         * Looks in the inventory system for an item with the same item id.
         * If that item id does not exists the method returns null
         * @param enteredItemId is the item id that should be matched with the inventory.
         * @return returns an item from the inventorysystem, if it is a match.
         * @throws InvalidItemIdException if the retrieved item id does not exist in inventory system.
         * @throws DatabaseException if the database can't be reached (simulated with id: 5).
         */
	public Item lookForItem(int enteredItemId) throws DatabaseException, InvalidItemIdException {
		for(int i = 0; i < inventory.length; i++) {
			if(inventory[i].getItemId() == enteredItemId) {
				return inventory[i];
			}
                        if(enteredItemId == 5){
                            throw new DatabaseException();
                        }
                        if(enteredItemId < 0 || inventory.length <= enteredItemId){
                            throw new InvalidItemIdException(enteredItemId);
                        }
		}
		return null;
	}
    
}
