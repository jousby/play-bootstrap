/*
 * Copyright 2013 Marconi Lanna
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package models

import persistence._

import java.util.Date

case class User
		( id             : PrimaryKey = NotAssigned
		, name           : String
		, legalName      : String
		, email          : String
		, password       : String
		, status         : String
		, created        : Date = new Date()
		, firstLogin     : Option[Date]
		, lastLogin      : Option[Date]
		, passwordChanged: Option[Date]
		, failedAttempts : Int = 0
		)
		extends UserActiveRecord {

	def username = email
}

object User extends UserDao
