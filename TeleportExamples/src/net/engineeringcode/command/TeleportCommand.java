package net.engineeringcode.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

import net.engineeringcode.mc.Teleport;

public class TeleportCommand implements CommandExecutor{

		private Teleport plugin;
		
		public TeleportCommand(Teleport plugin) {
			this.plugin = plugin;
			plugin.getCommand("teleport.teleport").setExecutor(this);
		}

		@Override
		public boolean onCommand(@Nullable CommandSender sender, @Nullable Command command, @Nullable String label, @Nullable String[] args) {
			Player commandSender = (Player) sender;
			if(commandSender.hasPermission("teleport.teleport")) {
				plugin.teleport(args[0], Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]));
				return true;
			}else {
				commandSender.sendMessage("이 명령어에 대한 권한을 가지고 있지 않습니다.");
			}
			return false;
		}
}
