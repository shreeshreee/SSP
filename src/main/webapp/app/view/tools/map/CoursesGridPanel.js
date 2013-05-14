/*
 * Licensed to Jasig under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Jasig licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a
 * copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
// Object only here to force scrolling on grid
Ext.define('Ssp.view.tools.map.CoursesGridPanel', {
   extend: 'Ext.panel.Panel',
    alias : 'widget.coursesgridpanel',
    mixins: [ 'Deft.mixin.Injectable',
              'Deft.mixin.Controllable'],
    width: '100%',
    height: 450,
    scroll: true,
    layout: {
                type: 'fit'
            },
    initComponent: function() { 
        Ext.apply(this,
		{items: [
		{
			xtype: 'coursesgrid'
		}
		]});

        return this.callParent(arguments);
    }
        
});