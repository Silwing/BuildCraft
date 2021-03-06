package buildcraft.api.transport;

import java.util.TreeMap;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.src.World;

public abstract class PipeManager {

	public static TreeMap<Integer, IPipedItem> allEntities = new TreeMap<Integer, IPipedItem>();   
	public static List<IExtractionHandler> extractionHandlers = new ArrayList<IExtractionHandler>();

	public static void registerExtractionHandler(IExtractionHandler handler) {
		extractionHandlers.add(handler);
	}

	public static boolean canExtractItems(IPipe pipe, World world, int i, int j, int k) {
		for(IExtractionHandler handler : extractionHandlers)
			if(!handler.canExtractItems(pipe, world, i, j, k))
				return false;

		return true;
	}

	public static boolean canExtractLiquids(IPipe pipe, World world, int i, int j, int k) {
		for(IExtractionHandler handler : extractionHandlers)
			if(!handler.canExtractLiquids(pipe, world, i, j, k))
				return false;

		return true;
	}
}
