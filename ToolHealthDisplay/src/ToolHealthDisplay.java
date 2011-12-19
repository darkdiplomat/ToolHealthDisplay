import java.util.logging.Logger;

public class ToolHealthDisplay extends Plugin{
	String name = "ToolHealthDisplay";
	String version = "1.1";
	String author = "Darkdiplomat";
	static Logger log = Logger.getLogger("Minecraft");

	public void initialize(){
		THDListener listener = new THDListener();
		etc.getLoader().addListener(PluginLoader.Hook.BLOCK_BROKEN, listener, this, PluginListener.Priority.MEDIUM);
		etc.getLoader().addListener(PluginLoader.Hook.COMMAND, listener, this, PluginListener.Priority.MEDIUM);
	}

	public void enable(){
		log.info(name + " version " + version + " by " + author + " is enabled!" );
	}

	public void disable(){
		log.info(name + " version " + version + " is disabled!");
	}
  
	public class THDListener extends PluginListener{
		public boolean onBlockBreak(Player player, Block block){
			Item itemInHand = player.getItemStackInHand();
			if(itemInHand != null && itemInHand.getType() != null){
				switch (itemInHand.getType()){
				//Wood Tools
				case WoodHoe:
				case WoodSpade:
				case WoodPickaxe:
				case WoodAxe:
					if (itemInHand.getDamage() == 49){
						player.sendMessage("§6Your tool is close to breaking.");
					}else if (itemInHand.getDamage() == 54){
						player.sendMessage("§cYour tool is dangerously close to breaking.");
					}else if (itemInHand.getDamage() == 58){
						player.sendMessage("§4Your tool will break on next use.");
					}
					return false;
					//Stone Tools
				case StoneHoe:
				case StoneSpade:
				case StonePickaxe:
				case StoneAxe:
					if (itemInHand.getDamage() == 121){
						player.sendMessage("§6Your tool is close to breaking.");
					}else if (itemInHand.getDamage() == 126){
						player.sendMessage("§cYour tool is dangerously close to breaking.");
					}else if (itemInHand.getDamage() == 130){
						player.sendMessage("§4Your tool will break on next use.");
					}
					return false;
					//Iron Tools
				case IronHoe:
				case IronSpade:
				case IronPickaxe:
				case IronAxe:
					if (itemInHand.getDamage() == 240){
						player.sendMessage("§6Your tool is close to breaking.");
					}else if (itemInHand.getDamage() == 245){
						player.sendMessage("§cYour tool is dangerously close to breaking.");
					}else if (itemInHand.getDamage() == 249){
						player.sendMessage("§4Your tool will break on next use.");
					}
					return false;
					//Gold Tools
				case GoldHoe:
				case GoldSpade:
				case GoldPickaxe:
				case GoldAxe:
					if (itemInHand.getDamage() == 22){
						player.sendMessage("§6Your tool is close to breaking.");
					}else if (itemInHand.getDamage() == 27){
						player.sendMessage("§cYour tool is dangerously close to breaking.");
					}else if (itemInHand.getDamage() == 31){
						player.sendMessage("§4Your tool will break on next use.");
					}
					return false;
					//Diamond Tools
				case DiamondHoe:
				case DiamondSpade:
				case DiamondPickaxe:
				case DiamondAxe:
					if (itemInHand.getDamage() == 1551){
						player.sendMessage("§6Your tool is close to breaking.");
					}else if (itemInHand.getDamage() == 1556){
						player.sendMessage("§cYour tool is dangerously close to breaking.");
					}else if (itemInHand.getDamage() == 1560){
						player.sendMessage("§4Your tool will break on next use.");
					}
					return false;
					//Not a tool
				default: return false;
				}
			}
			return false;
		}
		public boolean onCommand(Player player, String[] split){
			if (split[0].equalsIgnoreCase("/thd")){
				Item item = player.getItemStackInHand();
				String damagedisplay = null;
				int itemdamage;
				if(item != null && item.getType() != null){
					switch (item.getType()){
					case WoodHoe:
					case WoodSpade:
					case WoodPickaxe:
					case WoodAxe:
						itemdamage = 60 - item.getDamage();
						if (itemdamage < 5){
							damagedisplay = "§c" + String.valueOf(itemdamage) + "§b/§a60";
						}else if (itemdamage <= 20){
							damagedisplay = "§6" + String.valueOf(itemdamage) + "§b/§a60";
						}else if (itemdamage <= 40){
							damagedisplay = "§e" + String.valueOf(itemdamage) + "§b/§a60";
						}else if (itemdamage <= 60){
							damagedisplay = "§a" + String.valueOf(itemdamage) + "§b/§a60";
						}else{
							damagedisplay = "§1" + String.valueOf(itemdamage) + "§b/§a60";
						}
						player.sendMessage("§bYour tool's health is " + damagedisplay);
						return true;
					case StoneHoe:
					case StoneSpade:
					case StonePickaxe:
					case StoneAxe:
						itemdamage = 132 - item.getDamage();
						if (itemdamage < 5){
							damagedisplay = "§c" + String.valueOf(itemdamage) + "§b/§a132";
						}else if (itemdamage <= 44){
							damagedisplay = "§6" + String.valueOf(itemdamage) + "§b/§a132";
						}else if (itemdamage <= 88){
							damagedisplay = "§e" + String.valueOf(itemdamage) + "§b/§a132";
						}else if (itemdamage <= 132){
							damagedisplay = "§a" + String.valueOf(itemdamage) + "§b/§a132";
						}else{
							damagedisplay = "§1" + String.valueOf(itemdamage) + "§b/§a132";
						}
						player.sendMessage("§bYour tool's health is " + damagedisplay);
						return true;
					case IronHoe:
					case IronSpade:
					case IronPickaxe:
					case IronAxe:
						itemdamage = 251 - item.getDamage();
						if (itemdamage < 5){
							damagedisplay = "§c" + String.valueOf(itemdamage) + "§b/§a251";
						}else if (itemdamage <= 83){
							damagedisplay = "§6" + String.valueOf(itemdamage) + "§b/§a251";
						}else if (itemdamage <= 166){
							damagedisplay = "§e" + String.valueOf(itemdamage) + "§b/§a251";
						}else if (itemdamage <= 251){
							damagedisplay = "§a" + String.valueOf(itemdamage) + "§b/§a251";
						}else{
							damagedisplay = "§1" + String.valueOf(itemdamage) + "§b/§a251";
						}
						player.sendMessage("§bYour tool's health is " + damagedisplay);
						return true;
					case GoldHoe:
					case GoldSpade:
					case GoldPickaxe:
					case GoldAxe:
						itemdamage = 33 - item.getDamage();
						if (itemdamage < 5){
							damagedisplay = "§c" + String.valueOf(itemdamage) + "§b/§a33";
						}else if (itemdamage <= 11){
							damagedisplay = "§6" + String.valueOf(itemdamage) + "§b/§a33";
						}else if (itemdamage <= 22){
							damagedisplay = "§e" + String.valueOf(itemdamage) + "§b/§a33";
						}else if (itemdamage <= 33){
							damagedisplay = "§a" + String.valueOf(itemdamage) + "§b/§a33";
						}else{
							damagedisplay = "§1" + String.valueOf(itemdamage) + "§b/§a33";
						}
						player.sendMessage("§bYour tool's health is " + damagedisplay);
						return true;
					case DiamondHoe:
					case DiamondSpade:
					case DiamondPickaxe:
					case DiamondAxe:
						itemdamage = 1562 - item.getDamage();
						if (itemdamage < 5){
							damagedisplay = "§c" + String.valueOf(itemdamage) + "§b/§a1562";
						}else if (itemdamage <= 520){
							damagedisplay = "§6" + String.valueOf(itemdamage) + "§b/§a1562";
						}else if (itemdamage <= 1040){
							damagedisplay = "§e" + String.valueOf(itemdamage) + "§b/§a1562";
						}else if (itemdamage <= 1562){
							damagedisplay = "§a" + String.valueOf(itemdamage) + "§b/§a1562";
						}else{
							damagedisplay = "§1" + String.valueOf(itemdamage) + "§b/§a1562";
						}
						player.sendMessage("§bYour tool's health is " + damagedisplay);
						return true;
					default:
						player.sendMessage("§cThat is not a TOOL in your hand...");
						return true;
					}
				}
				player.sendMessage("§cThat is not a TOOL in your hand...");
				return true;
			}
			return false;
		}
	}
}