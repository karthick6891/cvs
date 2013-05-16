/*Copyright 2012 Google Inc. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
#limitations under the License.*/

BounceBallGunClass = WeaponClass.extend({
  itemID: "1232",
  // ABCD format ,hex
  
  drawPulse: 0,
  drawSide: false,
  onInit: function (owningPlayer) {
    this.parent(owningPlayer);
	this.energyCost = 8;
	this.fireDelayInSeconds = 0.5;
  },

  onFire: function (owningPlayer) {

    this.parent(owningPlayer);
	if(!this.firing)
		return;

    var gMap = gGameEngine.gMap;

    //cast a ray and see if we hit something
    var point1 = new Vec2(owningPlayer.pos.x, owningPlayer.pos.y);
    var dir = new Vec2(Math.cos(owningPlayer.faceAngleRadians), Math.sin(owningPlayer.faceAngleRadians));
    point1.x += dir.x * 20;
    point1.y += dir.y * 20;


    var ent = gGameEngine.spawnEntity("BounceBallBullet", point1.x - gMap.viewRect.x, point1.y - gMap.viewRect.y, {
		name:owningPlayer.name+"_BBB_"+gGameEngine.nextSpawnId(),
		owner:owningPlayer.name,
		pos:point1,
		dir:dir
		});
  },
});

//exports.Class = BounceBallGunClass;
Factory.nameClassMap['BounceBallGun'] = BounceBallGunClass;
