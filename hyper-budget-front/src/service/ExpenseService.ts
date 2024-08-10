import { IconProp } from "@fortawesome/fontawesome-svg-core";
import { faBowlFood, faBoxOpen, faCar, faChild, faHeartPulse, faHouse, faLaptop, faMugSaucer, faPaw, faQuestion, faSackDollar, faShield } from "@fortawesome/free-solid-svg-icons";
import { DefaultCategoryType } from "@model/type/DefaultCategoryType";

export default class ExpenseService {
    public static getIconFromCategory(category: DefaultCategoryType): IconProp {
      switch (category) {
        case "FOOD": return faBowlFood;
        case "TRANSPORT": return faCar;
        case "ANIMALS": return faPaw;
        case "HEALTH": return faHeartPulse;
        case "HOUSING": return faHouse;
        case "LEISURE": return faMugSaucer;
        case "CHILDREN": return faChild;
        case "DIGITAL": return faLaptop;
        case "INSURANCE": return faShield;
        case "TAXES": return faSackDollar;
        case "OTHER": return faBoxOpen;
        default: return faQuestion;
      }
    }

    public static getIconColorFromCategory(category: DefaultCategoryType): string {
      switch (category) {
        case "FOOD": return "#FFD643";
        case "TRANSPORT": return "#FFEB3C";
        case "ANIMALS": return "#038600";
        case "HEALTH": return "#FF6666";
        case "HOUSING": return "#CAB49F";
        case "LEISURE": return "#FFF500";
        case "CHILDREN": return "#44BAED";
        case "DIGITAL": return "#00CB82";
        case "INSURANCE": return "#AEB100";
        case "TAXES": return "#169D00";
        case "OTHER": return "#AB7644";
        default: return "#AB7644";
      }
    }
}