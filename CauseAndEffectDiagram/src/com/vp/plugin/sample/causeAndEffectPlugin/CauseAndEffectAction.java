package com.vp.plugin.sample.causeAndEffectPlugin;

import com.vp.plugin.ApplicationManager;
import com.vp.plugin.DiagramManager;
import com.vp.plugin.action.VPAction;
import com.vp.plugin.action.VPActionController;
import com.vp.plugin.diagram.IDiagramTypeConstants;
import com.vp.plugin.diagram.IFishboneDiagramUIModel;
import com.vp.plugin.model.IFishboneCategory;
import com.vp.plugin.model.IFishboneCause;
import com.vp.plugin.model.IFishboneDiagramModel;
import com.vp.plugin.model.factory.IModelElementFactory;

public class CauseAndEffectAction implements VPActionController{

	@Override
	public void performAction(VPAction arg0) {
		//Create blank diagram
		DiagramManager diagramManager = ApplicationManager.instance().getDiagramManager();
		IFishboneDiagramUIModel causeAndEffectDiagram = (IFishboneDiagramUIModel) diagramManager.createDiagram(IDiagramTypeConstants.DIAGRAM_TYPE_FISHBONE_DIAGRAM);
		causeAndEffectDiagram.setName("Sample Cause and Effect Diagram");
		
		//Create diagram model and problem
		IFishboneDiagramModel causeAndEffect = IModelElementFactory.instance().createFishboneDiagramModel();
		causeAndEffectDiagram.setFishboneDiagramModelAddress(causeAndEffect.getAddress());
		//Specify the potential problem
		causeAndEffect.setProblem("Difficulty on Locating a Drawing");
		
		//Create Categories
		IFishboneCategory man = causeAndEffect.createFishboneCategory();
		man.setName("Man");
		//Place the category on the top
		man.setPosition(IFishboneCategory.POSITION_TOP);
		//Add the category to the diagram
		causeAndEffect.addCategory(man);
		
		IFishboneCategory equipment = causeAndEffect.createFishboneCategory();
		equipment.setName("Equipment");
		//Place the category on the bottom
		equipment.setPosition(IFishboneCategory.POSITION_BOTTOM);
		causeAndEffect.addCategory(equipment);
		
		IFishboneCategory material = causeAndEffect.createFishboneCategory();
		material.setName("Material");
		material.setPosition(IFishboneCategory.POSITION_TOP);
		causeAndEffect.addCategory(material);
		
		IFishboneCategory method = causeAndEffect.createFishboneCategory();
		method.setName("Method");
		method.setPosition(IFishboneCategory.POSITION_BOTTOM);
		causeAndEffect.addCategory(method);
		
		IFishboneCategory environment = causeAndEffect.createFishboneCategory();
		environment.setName("Environment");
		environment.setPosition(IFishboneCategory.POSITION_TOP);
		causeAndEffect.addCategory(environment);
		
		
		//Create primary causes for category man
		IFishboneCause notAdequatelyInformed = IModelElementFactory.instance().createFishboneCause();
		notAdequatelyInformed.setName("Library workers aren't \nadequately informed");
		//Add the primary cause to the category
		man.addCause(notAdequatelyInformed);
		
		IFishboneCause dependLibraian = IModelElementFactory.instance().createFishboneCause();
		dependLibraian.setName("Patron depends too \nmuch on librarian");
		man.addCause(dependLibraian);
		
		IFishboneCause notWellTrained = IModelElementFactory.instance().createFishboneCause();
		notWellTrained.setName("Library workers \naren't well trained");
		man.addCause(notWellTrained);
		
		//Create primary causes for equipments
		IFishboneCause fillingCabinets = IModelElementFactory.instance().createFishboneCause();
		fillingCabinets.setName("Filling cabinets");
		equipment.addCause(fillingCabinets);
		
		IFishboneCause lackMachine = IModelElementFactory.instance().createFishboneCause();
		lackMachine.setName("Lack machine in \ncreating standard labels");
		equipment.addCause(lackMachine);
		
		//Create primary causes for material
		IFishboneCause unclearWriting = IModelElementFactory.instance().createFishboneCause();
		unclearWriting.setName("Unclear writing on \ndrawings");
		material.addCause(unclearWriting);
		
		IFishboneCause wrongCategory = IModelElementFactory.instance().createFishboneCause();
		wrongCategory.setName("Drawings are put \nunder wrong category");
		material.addCause(wrongCategory);
		
		//Create primary causes for method
		IFishboneCause nonDocumented = IModelElementFactory.instance().createFishboneCause();
		nonDocumented.setName("Non documented \nindexing procedure");
		method.addCause(nonDocumented);
		
		IFishboneCause improperOrganization = IModelElementFactory.instance().createFishboneCause();
		improperOrganization.setName("Improper organization \nprocedure");
		method.addCause(improperOrganization);
		
		//Create primary cause for environment
		IFishboneCause limitedSpace = IModelElementFactory.instance().createFishboneCause();
		limitedSpace.setName("Limited Space");
		environment.addCause(limitedSpace);
		
		
		//Create secondary causes for filling cabinets
		IFishboneCause drawingToHigh = fillingCabinets.createFishboneCause();
		drawingToHigh.setName("Drawings are put too \nhigh on cabinets");
		//Add secondary cause to the primary cause
		fillingCabinets.addSubCause(drawingToHigh);
		
		IFishboneCause lackClearLabel = fillingCabinets.createFishboneCause();
		lackClearLabel.setName("lack of clear labels");
		fillingCabinets.addSubCause(lackClearLabel);
		
		IFishboneCause scatteredCabinets = fillingCabinets.createFishboneCause();
		scatteredCabinets.setName("Canbinets are scattered");
		fillingCabinets.addSubCause(scatteredCabinets);
		
		//Create secondary causes for limited space
		IFishboneCause smallLibrary = limitedSpace.createFishboneCause();
		smallLibrary.setName("Small library");
		limitedSpace.addSubCause(smallLibrary);
		
		IFishboneCause overcrowdedCabinets = limitedSpace.createFishboneCause();
		overcrowdedCabinets.setName("Cabinets are overcrowded");
		limitedSpace.addSubCause(overcrowdedCabinets);
		
		
		//show up diagram
		diagramManager.openDiagram(causeAndEffectDiagram);
	}

	@Override
	public void update(VPAction arg0) {
		// TODO Auto-generated method stub
		
	}

}
