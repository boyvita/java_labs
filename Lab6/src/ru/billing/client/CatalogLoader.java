package ru.billing.client;

import ru.billing.stocklist.*;
import ru.billing.exceptions.CatalogLoadException;

public interface CatalogLoader {
    public void load(ItemCatalog cat) throws CatalogLoadException;
}
