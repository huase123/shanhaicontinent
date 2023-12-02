package hua.huase.shanhaicontinent.advancements.tupo;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import hua.huase.shanhaicontinent.ExampleMod;
import net.minecraft.advancements.ICriterionTrigger;
import net.minecraft.advancements.PlayerAdvancements;
import net.minecraft.advancements.critereon.AbstractCriterionInstance;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.JsonUtils;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ICriterionXishouHunHuan implements ICriterionTrigger<ICriterionXishouHunHuan.Instance> {

	public static final ResourceLocation ID = new ResourceLocation(ExampleMod.MODID, "xishouhunhuan");
	private final Map<PlayerAdvancements, Listeners> listeners = Maps.newHashMap();

	@Override
	public ResourceLocation getId() {
		return ID;
	}

	@Override
	public void addListener(PlayerAdvancements playerAdvancementsIn, Listener<Instance> listener) {
		Listeners listeners = this.listeners.computeIfAbsent(playerAdvancementsIn, Listeners::new);
		listeners.add(listener);
	}

	@Override
	public void removeListener(PlayerAdvancements playerAdvancementsIn, Listener<Instance> listener) {
		Listeners listeners = this.listeners.get(playerAdvancementsIn);
		if (listeners != null) {
			listeners.remove(listener);
			if (listeners.isEmpty()) {
				this.listeners.remove(playerAdvancementsIn);
			}
		}
	}

	@Override
	public void removeAllListeners(PlayerAdvancements playerAdvancementsIn) {
		this.listeners.remove(playerAdvancementsIn);
	}

	@Override
	public Instance deserializeInstance(JsonObject json, JsonDeserializationContext context) {
		int structureDengji = JsonUtils.getInt(json, "min");
		int max = JsonUtils.getInt(json, "max");
		return new Instance(structureDengji,max);
	}

	public void trigger(EntityPlayerMP player, int structureDengji) {
		Listeners listeners = this.listeners.get(player.getAdvancements());
		if (listeners != null) {
			listeners.trigger(structureDengji);
		}
	}

	public static class Instance extends AbstractCriterionInstance {

		private final int structureDengji;
		private final int max;

		public Instance(int structureDengji,int max) {
			super(ICriterionXishouHunHuan.ID);
			this.structureDengji = structureDengji;
			this.max = max;
		}

		boolean test(int structureDengji) {
			return this.structureDengji<=structureDengji && structureDengji<max;
		}
	}

	static class Listeners {

		private final PlayerAdvancements playerAdvancements;
		private final Set<Listener<Instance>> listeners = Sets.newHashSet();

		public Listeners(PlayerAdvancements playerAdvancementsIn) {
			this.playerAdvancements = playerAdvancementsIn;
		}

		public boolean isEmpty() {
			return this.listeners.isEmpty();
		}

		public void add(Listener<Instance> listener) {
			this.listeners.add(listener);
		}

		public void remove(Listener<Instance> listener) {
			this.listeners.remove(listener);
		}

		public void trigger(int structureDengji) {

			List<Listener<Instance>> list = new ArrayList<>();

			for (Listener<Instance> listener : this.listeners) {
				if (listener.getCriterionInstance().test(structureDengji)) {
					list.add(listener);
				}
			}

			for (Listener<Instance> listener : list) {
				listener.grantCriterion(this.playerAdvancements);
			}
		}
	}
}
