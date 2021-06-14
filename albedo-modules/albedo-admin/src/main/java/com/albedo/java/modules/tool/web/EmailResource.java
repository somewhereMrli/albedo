/*
 *  Copyright (c) 2019-2021  <a href="https://github.com/somowhere/albedo">Albedo</a>, somewhere (somewhere0813@gmail.com).
 *  <p>
 *  Licensed under the GNU Lesser General Public License 3.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  <p>
 * https://www.gnu.org/licenses/lgpl.html
 *  <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.albedo.java.modules.tool.web;

import com.albedo.java.common.log.annotation.LogOperate;
import com.albedo.java.modules.tool.domain.EmailConfig;
import com.albedo.java.modules.tool.domain.vo.EmailVo;
import com.albedo.java.modules.tool.service.EmailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 发送邮件
 *
 * @author 郑杰
 * @date 2018/09/28 6:55:53
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("${application.admin-path}/tool/email")
@Api(tags = "工具-邮件管理")
public class EmailResource {

	private final EmailService emailService;

	@GetMapping
	public ResponseEntity<Object> get() {
		return new ResponseEntity<>(emailService.find(), HttpStatus.OK);
	}

	@LogOperate("配置邮件")
	@PutMapping
	@ApiOperation("配置邮件")
	public ResponseEntity<Object> updateConfig(@Validated @RequestBody EmailConfig emailConfig) throws Exception {
		emailService.config(emailConfig, emailService.find());
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@LogOperate("发送邮件")
	@PostMapping
	@ApiOperation("发送邮件")
	public ResponseEntity<Object> send(@Validated @RequestBody EmailVo emailVo) {
		emailService.send(emailVo, emailService.find());
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
