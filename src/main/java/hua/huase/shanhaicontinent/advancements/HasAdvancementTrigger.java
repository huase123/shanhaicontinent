package hua.huase.shanhaicontinent.advancements;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import hua.huase.shanhaicontinent.ExampleMod;
import net.minecraft.advancements.Advancement;
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

public class HasAdvancementTrigger implements ICriterionTrigger<HasAdvancementTrigger.Instance> {

	public static final ResourceLocation ID = new ResourceLocation(ExampleMod.MODID, "has_advancement");
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
		ResourceLocation advancementId = new ResourceLocation(JsonUtils.getString(json, "advancement"));
		return new Instance(advancementId);
	}

	public void trigger(EntityPlayerMP player, Advancement advancement) {
		Listeners listeners = this.listeners.get(player.getAdvancements());
		if (listeners != null) {
			listeners.trigger(advancement);
		}
	}

	static class Instance extends AbstractCriterionInstance {

		private final ResourceLocation advancementLocation;

		Instance(ResourceLocation advancementLocation) {
			super(HasAdvancementTrigger.ID);
			this.advancementLocation = advancementLocation;
		}

		boolean test(Advancement advancement) {
			return advancementLocation.equals(advancement.getId());
		}
	}

	private static class Listeners {

		private final PlayerAdvancements playerAdvancements;
		private final Set<Listener<Instance>> listeners = Sets.newHashSet();

		Listeners(PlayerAdvancements playerAdvancements) {
			this.playerAdvancements = playerAdvancements;
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

		public void trigger(Advancement advancement) {
			List<Listener<Instance>> list = new ArrayList<>();

			for (Listener<Instance> listener : this.listeners) {
				if (listener.getCriterionInstance().test(advancement)) {
					list.add(listener);
				}
			}

			for (Listener<Instance> listener : list) {
				listener.grantCriterion(this.playerAdvancements);
			}
		}
	}
}
